package apitests;

import com.jayway.restassured.response.Header;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.anything;


/**
 * The GitHubSearchTest class to test Github critical search repositories issues.
 *
 * @author  Dounia Mdarhri Alaoui
 * @version 1.0
 * @since   2018-06-12
 */
public final class GithubSearchTests {

  private static final String GITHUB = "https://api.github.com/search";
  private static final Header HEADER = new Header("Accept", "application/vnd.github.mercy-preview+json");

  /*
  * Getting unmerged pull requests that have errors.
   */
  @Test
  public void test_unmerged_pull_request_with_error() {
    given().
            header(HEADER).
            queryParam("q", "error").
            queryParam("is:unmerged", "").
    when().
            get(GITHUB + "/issues").
    then().
            statusCode(200).
            body(containsString("error")).
            body("items.labels", anything(null));
  }

  /*
  * Getting repos by author name sorted, in ascending order and with pagination.
   */
  @Test
  public void test_author_name() {
    given().
            header(HEADER).
            queryParam("q", "author-name").
            queryParam("sort", "asc").
            queryParam("page", 3).
    when().
            get(GITHUB + "/repositories").
    then().
            statusCode(200).
            body(containsString("alihaji"));
  }
  /*
  * Getting vicentcox's repo and project "staCoAn and checking that it has 71 forks.
   */
  @Test
  public void test_author_vincentcox_has_forks(){
    given().
            header(HEADER).
            queryParam("q", "user:vincentcox").
            queryParam("project", "staCoAn").
            when().
            get(GITHUB + "/repositories").
            then().
            statusCode(200).
            body(containsString("vincentcox")).
            body("items.forks_count", anything("71"));
  }

  /*
  * Getting pull requests opened into C++ repositories where the status is pending.
   */
  @Test
  public void test_open_pending_requests(){
    given().
            header(HEADER).
            queryParam("q", "language:C++").
            queryParam("status", "pending").
            when().
            get(GITHUB + "/issues").
            then().
            statusCode(200).
            body(containsString("fail")).
            body("items.state", anything("open"));
  }

  /*
  * Getting pull requests opened on May 2018 with a failed status.
  */
  @Test
  public void test_open_failed_requests() throws InterruptedException {
    given().
            header(HEADER).
            queryParam("q", "created:2013-02-01").
            queryParam("status", "fail").
            when().
            get(GITHUB + "/issues").
            then().
            statusCode(200).
            body(containsString("fail")).
            body("items.updated_at", anything("\"2013-02-01T23:57:48Z\""));
  }

  /*
  * Getting pull requests that require a review before they can be merged.
   */
    @Test
  public void test_reviews_requiring_review() throws InterruptedException {
    given().
            header(HEADER).
            queryParam("q", ":pr").
            queryParam("review", "required").
            when().
            get(GITHUB + "/issues").
            then().
            statusCode(200).
            body(containsString("review")).
            body("items.body", anything("Requires discussion"));
  }

  //https://api.github.com/search/issues?q=state:closed&comments:0
  /*
  * Getting closed issues with 0 comments
   */
   @Test
   public void test_close_issues_with_zero_comments() throws InterruptedException {
     given().
             header(HEADER).
             queryParam("q", "state:closed").
             queryParam("comments", "0").
             when().
             get(GITHUB + "/issues").
             then().
             statusCode(200).
             body(containsString("closed")).
             body("items.comments", anything("0"));
   }

   /*
   * Getting merged pull request with the word bugxfix.
    */
     @Test
     public void test_pull_requests_with_bugfix(){
       given().
               header(HEADER).
               queryParam("q", "bugfix").
               queryParam("is:pr", "").
               queryParam("is:merged", "").
               when().
               get(GITHUB + "/issues").
               then().
               statusCode(200).
               body(containsString("bugfix")).
               body("items.body", anything("merged"));
     }


     /*
     * Getting repositories that with notifications
      */
     @Test
     public void test_repos_with_notification() {
       given().
               header(HEADER).
               queryParam("q", "Notifications").
               queryParam("Redesign", "").
               when().
               get(GITHUB + "/repositories").
               then().
               statusCode(200).
               body(containsString("Notifications")).
               body("items.has_issues", anything("true"));
     }

     //https://api.github.com/search/repositories?q=commit:rejected
     /*
      * Getting repositories that with rejected commits
      */
     @Test
     public void test_repos_with_rejected_commits() {
       given().
               header(HEADER).
               queryParam("q", "commit:rejected").
               when().
               get(GITHUB + "/repositories").
               then().
               statusCode(200).
               body(containsString("rejected")).
               body("items.description", anything("violate"));
     }
}


