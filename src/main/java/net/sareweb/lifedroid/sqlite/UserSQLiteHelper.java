package net.sareweb.lifedroid.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import net.sareweb.lifedroid.model.User;
import net.sareweb.lifedroid.sqlite.generic.LDSQLiteHelper;

public class UserSQLiteHelper extends LDSQLiteHelper<User> {

	public UserSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	public User findUserByEmail(String email){
		String[] emailAddress = new String[] {email};
		Cursor cur = getReadableDatabase().query(getTableName(), getFieldNames(), "emailAddress=?", emailAddress, null, null, null);
		if(cur==null || cur.getCount()==0){
			Log.d(TAG,"Object not found");
			return null;
		}
		cur.moveToFirst();
		return getObjectFromCursor(cur);
	}

}
