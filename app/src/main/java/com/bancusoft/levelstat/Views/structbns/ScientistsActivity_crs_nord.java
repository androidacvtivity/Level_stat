package com.bancusoft.levelstat.Views.structbns;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.bancusoft.levelstat.Helpers.Utils;

import com.bancusoft.levelstat.Helpers.structbns.MyAdapter_crs_nord;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.ResponseModel;
import com.bancusoft.levelstat.Retrofit.RestApi;
import com.bancusoft.levelstat.Retrofit.Scientist;
import com.bancusoft.levelstat.Views.help;
import com.bancusoft.levelstat.Views.helpen;
import com.bancusoft.levelstat.Views.helpru;
import com.bancusoft.levelstat.Views.structurabns;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScientistsActivity_crs_nord extends AppCompatActivity
        implements SearchView.OnQueryTextListener,MenuItem.OnActionExpandListener{
    //We define our instance fields
    private RecyclerView rv;
    private MyAdapter_crs_nord mAdapter;
    private LinearLayoutManager layoutManager;
    public ArrayList<Scientist> allPagesScientists = new ArrayList<>();
    private List<Scientist> currentPageScientists;
    private Boolean isScrolling = false;
    private int currentScientists, totalScientists, scrolledOutScientists;
    private ProgressBar mProgressBar;
    private Scientist receivedScientist;
    /**
     * We initialize our widgets
     */
    private void initializeViews() {
        mProgressBar = findViewById(R.id.mProgressBarLoads);
        mProgressBar.setIndeterminate(true);
        Utils.showProgressBar(mProgressBar);
        rv = findViewById(R.id.mRecyclerViews);
    }

    /**
     * This method will setup oir RecyclerView
     */
    private void setupRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter_crs_nord(this, allPagesScientists);
        rv.setAdapter(mAdapter);
        rv.setLayoutManager(layoutManager);
        rv.setBackgroundColor(Color.TRANSPARENT);
    }
    /**
     * This method will download for us data from php mysql based on supplied query string
     * as well as pagination parameters. We are basiclally searching or selecting data
     * without seaching. However all the arriving data is paginated at the server level.
     */
    private void retrieveAndFillRecyclerView(final String action,
                                             final String start) {


        String queryString = "CRS NORD";

        mAdapter.searchString = queryString;
        RestApi api = Utils.getClient().create(RestApi.class);
        Call<ResponseModel> retrievedData;

        if (action.equalsIgnoreCase("GET_PAGINATED")) {
            retrievedData = api.search("GET_PAGINATED", queryString, start, "20");
            Utils.showProgressBar(mProgressBar);
        } else


        if (action.equalsIgnoreCase("GET_PAGINATED_SEARCH")) {
            Utils.showProgressBar(mProgressBar);
            retrievedData = api.search("GET_PAGINATED_SEARCH", queryString, start, "20");
        } else


        {
            Utils.showProgressBar(mProgressBar);
            retrievedData = api.retrieve();
            //    retrievedData = api.search("GET_PAGINATED", queryString, start, limit);

        }


        retrievedData.enqueue(new Callback<ResponseModel>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<ResponseModel> call, @NonNull Response<ResponseModel>
                    response) {
                assert response.body() != null;
                Log.d("RETROFIT", "CODE : " + response.body().getCode());
                Log.d("RETROFIT", "MESSAGE : " + response.body().getMessage());
                Log.d("RETROFIT", "RESPONSE : " + response.body().getResult());
                currentPageScientists = response.body().getResult();

                if (currentPageScientists != null && currentPageScientists.size() > 0) {
                    if (action.equalsIgnoreCase("GET_PAGINATED_SEARCH")) {
                        allPagesScientists.clear();
                    }
                    allPagesScientists.addAll(currentPageScientists);

                } else {
                    if (action.equalsIgnoreCase("GET_PAGINATED_SEARCH")) {
                        allPagesScientists.clear();
                    }
                }
                mAdapter.notifyDataSetChanged();
                Utils.hideProgressBar(mProgressBar);
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModel> call, @NonNull Throwable t) {
                Utils.hideProgressBar(mProgressBar);
                Log.d("RETROFIT", "ERROR: " + t.getMessage());
                Utils.showInfoDialog(ScientistsActivity_crs_nord.this, "ERROR", t.getMessage());
            }
        });
    }
    /**
     * We will listen to scroll events. This is important as we are implementing scroll to
     * load more data pagination technique
     */
    private void listenToRecyclerViewScroll() {
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView rv, int newState) {
                //when scrolling starts
                super.onScrollStateChanged(rv, newState);
                //check for scroll state
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }
            @Override
            public void onScrolled(@NonNull RecyclerView rv, int dx, int dy) {
                // When the scrolling has stopped
                super.onScrolled(rv, dx, dy);
                currentScientists = layoutManager.getChildCount();
                totalScientists = layoutManager.getItemCount();
                scrolledOutScientists = ((LinearLayoutManager) Objects.requireNonNull(rv.getLayoutManager())).
                        findFirstVisibleItemPosition();

                if (isScrolling && (currentScientists + scrolledOutScientists ==
                        totalScientists)) {
                    isScrolling = false;

                    if (dy > 0) {
                        // Scrolling up
                        retrieveAndFillRecyclerView("GET_PAGINATED",
                                String.valueOf(totalScientists));

                    } else {
                        // Scrolling down
                    }
                }
            }
        });
    }
    ////    /**
////     * We inflate our menu. We show SearchView inside the toolbar
////     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_page_menu_str, menu);
        return true;
    }



    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_str:
                Utils.sendScientistToActivity(this,receivedScientist, help.class);
                finish();
                return true;


            case R.id.action_edit_en_str:
                Utils.sendScientistToActivity(this,receivedScientist, helpen.class);
                finish();
                return true;

            case R.id.action_edit_ru_str:
                Utils.sendScientistToActivity(this,receivedScientist, helpru.class);
                finish();
                return true;

            case android.R.id.home:
                Intent intent;
                intent = new Intent(this, structurabns.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);

                return true;

            case R.id.video3_str:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.levelstat.Helpers.Utils.youtube_level_stat ));
                startActivity(browserIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        retrieveAndFillRecyclerView("GET_PAGINATED_SEARCH", "0");
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return false;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(this, structurabns.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientists_str);

        initializeViews();
        this.listenToRecyclerViewScroll();
        setupRecyclerView();
        retrieveAndFillRecyclerView("GET_PAGINATED", "0");
    }

    public void setReceivedScientist(Scientist receivedScientist) {
        this.receivedScientist = receivedScientist;
    }
}
