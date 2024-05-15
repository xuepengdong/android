package provider;

import android.net.Uri;
import android.provider.BaseColumns;
import database.UserDBHelper;

public class UserInfoContent implements BaseColumns {
    public static final String AUTHORITILES = "database.provider.UserInfoProvider";
    public static final String TABLE_NAME = UserDBHelper.TABLE_NAME;
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITILES + "/user");
    public static final String USER_NAME = "name";
    public static final String USER_AGE = "age";
    public static final String USER_HEIGHT = "height";
    public static final String USER_WEIGHT = "weight";
    public static final String USER_MARRIED = "married";
    public static final String DEFAULT_SORT_ORDER = "_id desc";
}
