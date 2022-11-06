package ui_pages.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginForm {
    @Expose
    @SerializedName("user_name")
    private String userName;
    @Expose
    private String password;
}
