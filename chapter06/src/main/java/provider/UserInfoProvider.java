package provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.database.sqlite.SQLiteDatabase;

import database.UserDBHelper;

public class UserInfoProvider extends ContentProvider {
    private  UserDBHelper userDB;
    public static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    public static final int USER_INFO = 1;
    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        userDB = UserDBHelper.getInstance(getContext(), 1);
        return false;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if(uriMatcher.match(uri) == USER_INFO){
            SQLiteDatabase db = userDB.getWritableDatabase();
            long rowId = db.insert(UserInfoContent.TABLE_NAME, null, values);
            if(rowId > 0){
                Uri newUri = ContentUris.withAppendedId(UserInfoContent.CONTENT_URI, rowId);
                getContext().getContentResolver().notifyChange(newUri, null);
            }
            db.close();
        }
        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        if(uriMatcher.match(uri) == USER_INFO){
            SQLiteDatabase db = userDB.getWritableDatabase();
            count = db.delete(UserInfoContent.TABLE_NAME, selection, selectionArgs);
            db.close();
        }
        return count;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;
        if(uriMatcher.match(uri) == USER_INFO){
            SQLiteDatabase db = userDB.getWritableDatabase();
            cursor = db.query(UserInfoContent.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder);
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

    public UserInfoProvider() {
    }


    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }




    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}