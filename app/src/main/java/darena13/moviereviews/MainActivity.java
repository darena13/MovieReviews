package darena13.moviereviews;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.net.URI;
import java.net.URL;
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

    private Button readMoreButton;

    private List<Result> reviews = new ArrayList<>();
    private NYTimesAPI networkAPI;


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        networkAPI = retrofit.create(NYTimesAPI.class);

        String myApi = "2982d29303d1454fbdef02fb8e4900d2";
        Observable<Response> reviewsObservable = networkAPI.getReviews(myApi)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        reviewsObservable.subscribe(new Observer<Response>(){
            @Override
            public void onSubscribe(Disposable d) {
                Toast.makeText(getApplicationContext(),"onSubscribe", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Response value) {
                Toast.makeText(getApplicationContext(),"onNext", Toast.LENGTH_SHORT).show();
                int size = value.getResults().size();
                for (int i = 0; i < size; i++) {
                    reviews.add(value.getResults().get(i));
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e){
                Toast.makeText(getApplicationContext(),"onError" + e, Toast.LENGTH_LONG).show();
//                Log.e()
                //handle error
            }

            @Override
            public void onComplete() {
                Toast.makeText(getApplicationContext(),"onComplete", Toast.LENGTH_SHORT).show();

            }

        });

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(reviews);
        mRecyclerView.setAdapter(mAdapter);

//        readMoreButton = (Button) findViewById(R.id.read_more);
//        readMoreButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void readMore(View view) {
        Uri uri = Uri.parse("http://www.google.com");
//        Uri uri = Uri.parse(reviews.get(position).getLink().getUrl());

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
