import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * News story integration model.
 */
@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
public class GuardianStoriesIntegrationModel extends AbstractResponseIntegrationModel {

    @XmlPath("channel/copyright")
    private String copyRight;

    /** List of {@link GuardianStoryIntegrationModel} */
    @XmlElementWrapper(name = "channel")
    @XmlElement(name = "item")
    private List<GuardianStoryIntegrationModel> guardianStoryIntegrationModels;


    /**
     * Gets guardianStoryIntegrationModels.
     *
     * @return Value of guardianStoryIntegrationModels.
     */
    public List<GuardianStoryIntegrationModel> getGuardianStoryIntegrationModels() {
        return guardianStoryIntegrationModels;
    }

    /**
     * Sets new guardianStoryIntegrationModels.
     *
     * @param guardianStoryIntegrationModels
     *         New value of guardianStoryIntegrationModels.
     */
    public void setGuardianStoryIntegrationModels(List<GuardianStoryIntegrationModel> guardianStoryIntegrationModels) {
        this.guardianStoryIntegrationModels = guardianStoryIntegrationModels;
    }

    /**
     * Gets copyRight.
     *
     * @return Value of copyRight.
     */
    public String getCopyRight() {
        return copyRight;
    }

    /**
     * Sets new copyRight.
     *
     * @param copyRight
     *         New value of copyRight.
     */
    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    /**
     * To string builder
     */
    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(copyRight).append(guardianStoryIntegrationModels);

        return stringBuilder.toString();
    }
}
