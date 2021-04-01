package com.bancusoft.levelstat.Views.med;


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

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.bancusoft.levelstat.Helpers.cl_medicament.MyAdapter_cl_med;
import com.bancusoft.levelstat.Helpers.MyAdapter;
import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.ResponseModel;
import com.bancusoft.levelstat.Retrofit.ResponseModel_Cl_medicament;
import com.bancusoft.levelstat.Retrofit.RestApi;
import com.bancusoft.levelstat.Retrofit.Scientist;

import com.bancusoft.levelstat.Retrofit.Cl_medicament;
import com.bancusoft.levelstat.Views.DashboardActivity;
import com.bancusoft.levelstat.Views.ScientistsActivity;
import com.bancusoft.levelstat.Views.help;
import com.bancusoft.levelstat.Views.helpen;
import com.bancusoft.levelstat.Views.helpru;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class CL_medicament_Activity extends AppCompatActivity  implements SearchView.OnQueryTextListener,MenuItem.OnActionExpandListener{

    //We define our instance fields
    private RecyclerView rv;
    private MyAdapter_cl_med mAdapter;
    private LinearLayoutManager layoutManager;
    public ArrayList<Cl_medicament> allPagesScientists = new ArrayList();
    private List<Cl_medicament> currentPageScientists;
    private Boolean isScrolling = false;
    private int currentScientists, totalScientists, scrolledOutScientists;
    private ProgressBar mProgressBar;
    private Scientist receivedScientist;

    private Cl_medicament receivedCl_medicament;

    /**
     * We initialize our widgets
     */
    private void initializeViews() {
        mProgressBar = findViewById(R.id.mProgressBarLoad_cl_med1);
        mProgressBar.setIndeterminate(true);
        Utils.showProgressBar(mProgressBar);
        rv = findViewById(R.id.mRecyclerView_cl_med1);
    }

    /**
     * This method will setup oir RecyclerView
     */
    private void setupRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter_cl_med(this, allPagesScientists);
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

        mAdapter.searchString = queryString;
        RestApi api = Utils.getClient().create(RestApi.class);
        Call<ResponseModel_Cl_medicament> retrievedData;

        if (action.equalsIgnoreCase("GET_PAGINATEDCLMED")) {
            retrievedData = api.search_cl_medicament("GET_PAGINATEDCLMED", queryString, start, limit);
            Utils.showProgressBar(mProgressBar);
        } else


        if (action.equalsIgnoreCase("GET_PAGINATED_SEARCHCLMED")) {
            Utils.showProgressBar(mProgressBar);
            retrievedData = api.search_cl_medicament("GET_PAGINATED_SEARCHCLMED", queryString, start, limit);
        } else


        {
            Utils.showProgressBar(mProgressBar);
            retrievedData = api.retrievecl_medicament();
            //    retrievedData = api.search("GET_PAGINATED", queryString, start, limit);

        }


        retrievedData.enqueue(new Callback<ResponseModel_Cl_medicament>() {
            @Override
            public void onResponse(Call<ResponseModel_Cl_medicament> call, Response<ResponseModel_Cl_medicament>
                    response) {
                Log.d("RETROFIT", "CODE : " + response.body().getCodecu());
                Log.d("RETROFIT", "MESSAGE : " + response.body().getMessagecu());
                Log.d("RETROFIT", "RESPONSE : " + response.body().getResultCl_medicament());
                currentPageScientists = response.body().getResultCl_medicament();

                if (currentPageScientists != null && currentPageScientists.size() > 0) {
                    if (action.equalsIgnoreCase("GET_PAGINATED_SEARCHCLMED")) {
                        allPagesScientists.clear();
                    }
                    for (int i = 0; i < currentPageScientists.size(); i++) {
                        allPagesScientists.add(currentPageScientists.get(i));
                    }

                } else {
                    if (action.equalsIgnoreCase("GET_PAGINATED_SEARCHCLMED")) {
                        allPagesScientists.clear();
                    }
                }
                mAdapter.notifyDataSetChanged();
                Utils.hideProgressBar(mProgressBar);
            }

            @Override
            public void onFailure(Call<ResponseModel_Cl_medicament> call, Throwable t) {
                Utils.hideProgressBar(mProgressBar);
                Log.d("RETROFIT", "ERROR: " + t.getMessage());
                Utils.showInfoDialog(CL_medicament_Activity.this, "ERROR", t.getMessage());
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
                        retrieveAndFillRecyclerView("GET_PAGINATEDCLMED",
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.medicament_page_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search_med);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setIconified(true);
        searchView.setQueryHint("Căutare med.");
        return true;
    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_new:
//                Utils.openActivity(this, help.class);
//                finish();
//                return true;
//
//            case R.id.action_new_en:
//                Utils.openActivity(this, helpen.class);
//                finish();
//                return true;
//
//
//            case R.id.action_new_ru:
//                Utils.openActivity(this, helpru.class);
//                finish();
//                return true;
//
//            case R.id.home:
//                Utils.openActivity(this, DashboardActivity.class);
//                finish();
//                return true;
////            case R.id.dgti:
////                Utils.openActivity(this, ScientistsActivity_dgti.class);
////                finish();
////                return true;
//
//
//            case R.id.video2:
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.nextlevel.Helpers.Utils.youtube_level_stat ));
//                startActivity(browserIntent);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_med:
                Utils.sendScientistToActivity(this,receivedScientist, help_medicament.class);
                finish();
                return true;


            case R.id.action_new_en_med:
                Utils.sendScientistToActivity(this,receivedScientist, help_medicament_en.class);
                finish();
                return true;

            case R.id.action_new_ru_med:
                Utils.sendScientistToActivity(this,receivedScientist, help_medicament_ru.class);
                finish();
                return true;

            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
//                Utils.sendScientistToActivity(this,receivedScientist,structurabns.class);
//                finish();
//
                Intent intent;
                intent = new Intent(this, DashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);

                return true;

//            case R.id.back_str:
//                Utils.openActivity(this, structurabns.class);
//                finish();
//                return true;

            case R.id.video2_med:
                //   String test_url = "https://www.youtube.com/watch?v=GovpbmgZY_E";
                //  Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=GovpbmgZY_E"));
                //  Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(test_url));


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.levelstat.Helpers.Utils.youtube_Stat_Level));

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
        retrieveAndFillRecyclerView("GET_PAGINATED_SEARCHCLMED", query, "0", "20");
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
        intent = new Intent(this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl_med);

        initializeViews();
        this.listenToRecyclerViewScroll();
        setupRecyclerView();
        retrieveAndFillRecyclerView("GET_PAGINATEDCLMED", "", "0", "20");
    }

}
