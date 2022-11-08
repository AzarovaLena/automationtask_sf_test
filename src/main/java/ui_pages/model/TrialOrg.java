package ui_pages.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class TrialOrg {
    @Expose
    @SerializedName("user_name")
    private String userName;
    @Expose
    private String password;
    @Expose
    private String email;
    @Expose
    @SerializedName("account_name")
    private String accountName;
    @Expose
    private String phone;
    @Expose
    @SerializedName("new_name")
    private String newName;
}
