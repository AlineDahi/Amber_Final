package com.queens.amber

class HospitalDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "hospital.db"
        const val DATABASE_VERSION = 1
        const val TABLE_HOSPITALS = "hospitals"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_ADDRESS = "address"
        const val COLUMN_PHONE = "phone"
        const val COLUMN_EMAIL = "email"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_HOSPITALS " +
                "($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT," +
                "$COLUMN_ADDRESS TEXT, $COLUMN_PHONE TEXT, $COLUMN_EMAIL TEXT)"
        db?.execSQL(createTable)
    }

}