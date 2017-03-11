import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Test for {@link GuardianStoryIntegrationMapper}
 */
public class GuardianStoryIntegrationMapperTest {

    /** {@link GuardianStoryIntegrationMapper} */
    private GuardianStoryIntegrationMapper guardianStoryIntegrationMapper;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        guardianStoryIntegrationMapper = new GuardianStoryIntegrationMapperHandler();
    }

    /**
     *
     */
    @Test
    public void checkMapper() throws MalformedURLException {

        //Setup
        final NewsStoryModel newsStoryModel = new NewsStoryModel();
        newsStoryModel.setTitle("TestTitle");
        newsStoryModel.setAuthor("TestAuthor");
        newsStoryModel.setDescription("TestDescription");
        newsStoryModel.setUrlToImage(Arrays.asList(new URL("http://www.TestUrlImg.com")));
        newsStoryModel.setUrl(new URL("http://www.TestUrl.com"));
        newsStoryModel.setCopyRight("TestCopyRight");
        newsStoryModel.setPublishedAt("TestPublishedAt");

        final GuardianStoryIntegrationModel guardianStoryIntegrationModel = new GuardianStoryIntegrationModel();
        guardianStoryIntegrationModel.setTitle("TestTitle");
        guardianStoryIntegrationModel.setAuthor("TestAuthor");
        guardianStoryIntegrationModel.setDescription("TestDescription");
        guardianStoryIntegrationModel.setUrlToImage(Arrays.asList(new URL("http://www.TestUrlImg.com")));
        guardianStoryIntegrationModel.setUrl(new URL("http://www.TestUrl.com"));
        guardianStoryIntegrationModel.setPublishedAt("TestPublishedAt");
        final GuardianStoriesIntegrationModel guardianStoriesIntegrationModel = new GuardianStoriesIntegrationModel();
        guardianStoriesIntegrationModel.setGuardianStoryIntegrationModels(Arrays.asList(guardianStoryIntegrationModel));
        guardianStoriesIntegrationModel.setCopyRight("TestCopyRight");

        //Test
        final List<NewsStoryModel> newsStoryModelList = guardianStoryIntegrationMapper.map
                (guardianStoriesIntegrationModel);

        //Assertion
        Assert.assertEquals(newsStoryModel.toString(), newsStoryModelList.get(0).toString());
    }
}
