package darena13.moviereviews;

import java.util.List;

import darena13.moviereviews.Model.Review;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by darena13 on 08.08.2017.
 */

public interface NYTimesAPI {
//    String END_POINT = "https://api.nytimes.com/svc/movies/v2/";

//    @GET("reviews/all.json")
//    Observable<List<Review>> getReviews(@Header("api-key") String MyApi);

    @GET("reviews/all.json")
    Observable<List<Review>> getReviews(@Header("api-key") String MyApiKey);
}
