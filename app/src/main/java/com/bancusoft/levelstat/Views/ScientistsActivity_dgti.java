package com.bancusoft.levelstat.Views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.bancusoft.levelstat.Helpers.MyAdapter_dgti;
import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.ResponseModel;
import com.bancusoft.levelstat.Retrofit.RestApi;
import com.bancusoft.levelstat.Retrofit.Scientist;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScientistsActivity_dgti extends AppCompatActivity
        implements SearchView.OnQueryTextListener,MenuItem.OnActionExpandListener{

    //We define our instance fields
    private RecyclerView rv;
    private MyAdapter_dgti mAdapter;
    private LinearLayoutManager layoutManager;
    public ArrayList<Scientist> allPagesScientists = new ArrayList();
    private List<Scientist> currentPageScientists;
    private Boolean isScrolling = false;
    private int currentScientists, totalScientists, scrolledOutScientists;
    private ProgressBar mProgressBar;
    private Scientist receivedScientist;

    /**
     * We initialize our widgets
     */
    private void initializeViews() {
        mProgressBar = findViewById(R.id.mProgressBarLoad);
        mProgressBar.setIndeterminate(true);
        Utils.showProgressBar(mProgressBar);
        rv = findViewById(R.id.mRecyclerView);
    }

    /**
     * This method will setup oir RecyclerView
     */
    private void setupRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter_dgti(this, allPagesScientists);
        rv.setAdapter(mAdapter);
        rv.setLayoutManager(layoutManager);
        rv.setBackgroundColor(Color.TRANSPARENT);
    }
    /**
     * This method will download for us data from php mysql based on supplied query string
     * as well as pagination parameters. We are basiclally searching or selecting data
     * without seaching. However all the arriving data is paginated at the server level.
     */
    private void retrieveAndFillRecyclerView(final String action, String queryString,
                                             final String start, String limit) {
        String director = "tehnologii informationale";

        queryString  = director;
        mAdapter.searchString = queryString;
        RestApi api = Utils.getClient().create(RestApi.class);
        Call<ResponseModel> retrievedData;

        if (action.equalsIgnoreCase("GET_PAGINATED_DGTI")) {
            retrievedData = api.search_dgti("GET_PAGINATED_DGTI", queryString, start, limit);
            Utils.showProgressBar(mProgressBar);
        } else


        if (action.equalsIgnoreCase("GET_PAGINATED_SEARCH_DGTI")) {
            Utils.showProgressBar(mProgressBar);
            retrievedData = api.search_dgti("GET_PAGINATED_SEARCH_DGTI", queryString, start, limit);
        } else


        {
            Utils.showProgressBar(mProgressBar);
            retrievedData = api.retrieve();
        }


        retrievedData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel>
                    response) {
                Log.d("RETROFIT", "CODE : " + response.body().getCode());
                Log.d("RETROFIT", "MESSAGE : " + response.body().getMessage());
                Log.d("RETROFIT", "RESPONSE : " + response.body().getResult());
                currentPageScientists = response.body().getResult();

                if (currentPageScientists != null && currentPageScientists.size() > 0) {
                    if (action.equalsIgnoreCase("GET_PAGINATED_SEARCH_DGTI")) {
                        allPagesScientists.clear();
                    }
                    for (int i = 0; i < currentPageScientists.size(); i++) {
                        allPagesScientists.add(currentPageScientists.get(i));
                    }

                } else {
                    if (action.equalsIgnoreCase("GET_PAGINATED_SEARCH_DGTI")) {
                        allPagesScientists.clear();
                    }
                }
                mAdapter.notifyDataSetChanged();
                Utils.hideProgressBar(mProgressBar);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Utils.hideProgressBar(mProgressBar);
                Log.d("RETROFIT", "ERROR: " + t.getMessage());
                Utils.showInfoDialog(ScientistsActivity_dgti.this, "ERROR", t.getMessage());
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
            public void onScrollStateChanged(RecyclerView rv, int newState) {
                //when scrolling starts
                super.onScrollStateChanged(rv, newState);
                //check for scroll state
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }
            @Override
            public void onScrolled(RecyclerView rv, int dx, int dy) {
                // When the scrolling has stopped
                super.onScrolled(rv, dx, dy);
                currentScientists = layoutManager.getChildCount();
                totalScientists = layoutManager.getItemCount();
                scrolledOutScientists = ((LinearLayoutManager) rv.getLayoutManager()).
                        findFirstVisibleItemPosition();

                if (isScrolling && (currentScientists + scrolledOutScientists ==
                        totalScientists)) {
                    isScrolling = false;

                    if (dy > 0) {
                        // Scrolling up
                        retrieveAndFillRecyclerView("GET_PAGINATED_DGTI",
                                mAdapter.searchString,
                                String.valueOf(totalScientists), "20");

                    } else {
                        // Scrolling down
                    }
                }
            }
        });
    }


    /**
     * We inflate our menu. We show SearchView inside the toolbar
     */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.scientists_page_menu_dgti, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search_dgti);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setOnQueryTextListener(this);
//        searchView.setIconified(true);
//        searchView.setQueryHint("Căutare");
//        return true;
//    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu_str, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

//            case R.id.action_new_dgti:
//                Utils.openActivity(this, help.class);
//                finish();
//                return true;
//
//            case R.id.action_new_en_dgti:
//                Utils.openActivity(this, helpen.class);
//                finish();
//                return true;
//
//
//            case R.id.action_new_ru_dgti:
//                Utils.openActivity(this, helpru.class);
//                finish();
//                return true;
//
////            case R.id.home:
////                Utils.openActivity(this, AboutUsActivity.class);
////                finish();
////                return true;
//
//
//            case android.R.id.home:
//
//
//                Intent intent;
//                intent = new Intent(this, AboutUsActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                finish();
//                startActivity(intent);
//                return true;
//
//
//
//
//            case R.id.video2_dgti:
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.nextlevel.Helpers.Utils.youtube_level_stat ));
//                startActivity(browserIntent);
//                break;

            case R.id.action_edit_str:
                Utils.sendScientistToActivity(this,receivedScientist,help.class);
                finish();
                return true;


            case R.id.action_edit_en_str:
                Utils.sendScientistToActivity(this,receivedScientist,helpen.class);
                finish();
                return true;

            case R.id.action_edit_ru_str:
                Utils.sendScientistToActivity(this,receivedScientist,helpru.class);
                finish();
                return true;

            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
//                Utils.sendScientistToActivity(this,receivedScientist,structurabns.class);
//                finish();

                Intent intent;
                intent = new Intent(this, AboutUsActivity.class);
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
        retrieveAndFillRecyclerView("GET_PAGINATED_SEARCH_DGTI", query, "0", "20");
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

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        this.finish();
//    }


    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(this, AboutUsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientists);

        initializeViews();
        this.listenToRecyclerViewScroll();
        setupRecyclerView();
        retrieveAndFillRecyclerView("GET_PAGINATED_DGTI", "", "0", "20");
    }

}
