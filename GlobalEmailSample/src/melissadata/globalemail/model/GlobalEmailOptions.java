package melissadata.globalemail.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GlobalEmailOptions {

    private final StringProperty optionVerifyMailBox;
    private final StringProperty optionDomainCorrection;
    private final StringProperty optionTimeToWait;
    private final StringProperty optionWhoIs;

    public GlobalEmailOptions() {
        optionVerifyMailBox = new SimpleStringProperty("");
        optionDomainCorrection = new SimpleStringProperty("");
        optionTimeToWait = new SimpleStringProperty("");
        optionWhoIs = new SimpleStringProperty("");
    }

    public String generateOptionString() {
        String optionString = "";
		
		if(!getOptionWhoIs().equals(""))
			optionString += "WhoIsLookup:" + getOptionWhoIs();
        if(!getOptionVerifyMailBox().equals("") && !optionString.equals(""))
            optionString += ",VerifyMailbox:" + getOptionVerifyMailBox();
        else if(!getOptionVerifyMailBox().equals("") && optionString.equals(""))
        	optionString += "VerifyMailbox:" + getOptionVerifyMailBox();
        if(!getOptionDomainCorrection().equals("") && !optionString.equals(""))
            optionString += ",DomainCorrection:" + getOptionDomainCorrection();
        else if(!getOptionDomainCorrection().equals("") && optionString.equals(""))
            optionString += "DomainCorrection:" + getOptionDomainCorrection();

        if(!getOptionTimeToWait().equals("") && !optionString.equals(""))
            optionString += ",TimeToWait:" + getOptionTimeToWait();
        else if(!getOptionTimeToWait().equals("") && optionString.equals(""))
            optionString += "TimeToWait:" + getOptionTimeToWait();

        return optionString;
    }

    public String getOptionVerifyMailBox() {
        return optionVerifyMailBox.get();
    }

    public StringProperty optionVerifyMailBoxProperty() {
        return optionVerifyMailBox;
    }

    public void setOptionVerifyMailBox(String optionVerifyMailBox) {
        this.optionVerifyMailBox.set(optionVerifyMailBox);
    }

    public String getOptionDomainCorrection() {
        return optionDomainCorrection.get();
    }

    public StringProperty optionDomainCorrectionProperty() {
        return optionDomainCorrection;
    }

    public void setOptionDomainCorrection(String optionDomainCorrection) {
        this.optionDomainCorrection.set(optionDomainCorrection);
    }

    public String getOptionTimeToWait() {
        return optionTimeToWait.get();
    }

    public StringProperty optionTimeToWaitProperty() {
        return optionTimeToWait;
    }

    public void setOptionTimeToWait(String optionTimeToWait) {
        this.optionTimeToWait.set(optionTimeToWait);
    }
    
    public String getOptionWhoIs() {
    	return optionWhoIs.get();
    }
    public StringProperty optionWhoIs() {
    	return optionWhoIs;
    }
    public void setOptionWhoIs(String optionWhoIs) {
    	this.optionWhoIs.set(optionWhoIs);
    }
}
