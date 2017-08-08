package darena13.moviereviews;

import darena13.moviereviews.Model.Response;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by darena13 on 08.08.2017.
 */

public interface NYTimesAPI {
    @GET("reviews/all.json")
    Observable<Response> getReviews(@Header("api-key") String MyApiKey);
}
