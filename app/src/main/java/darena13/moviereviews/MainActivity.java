package darena13.moviereviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import darena13.moviereviews.Model.Response;
import darena13.moviereviews.Model.Result;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String baseUrl = "https://api.nytimes.com/svc/movies/v2/";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Result> reviews = new ArrayList<>();
    private NYTimesAPI networkAPI;


    @Override
    protected void onStart() {
        super.onStart();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        networkAPI = retrofit.create(NYTimesAPI.class);

        String myApi = BuildConfig.MY_API_KEY;
        Observable<Response> reviewsObservable = networkAPI.getReviews(myApi)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        reviewsObservable.subscribe(new Observer<Response>(){
            @Override
            public void onSubscribe(Disposable d) {
//                Toast.makeText(getApplicationContext(),"onSubscribe", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Response value) {
//                Toast.makeText(getApplicationContext(),"onNext", Toast.LENGTH_SHORT).show();

                int size = value.getResults().size();
                for (int i = 0; i < size; i++) {
                    reviews.add(value.getResults().get(i));
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e){
                Toast.makeText(getApplicationContext(),"onError" + e, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete() {
//                Toast.makeText(getApplicationContext(),"onComplete", Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(reviews);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
