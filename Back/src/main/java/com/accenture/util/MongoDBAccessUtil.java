package com.accenture.util;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoDBAccessUtil {

	public String[][] selectAllRecordsFromACollection(DBCollection collection,
			String[] fields, String recordName, String recordValue,
			boolean checkDeleted) {
		BasicDBObject query = new BasicDBObject();

		if (recordName != null && recordValue != null) {
			query.put(recordName, recordValue);
			if (checkDeleted) {
				query.put("deleted", false);
			}
		}

		DBCursor cursor = collection.find(query);
		int cursorLength = cursor.count();
		String[][] clientFieldValues = new String[cursorLength][fields.length];
		int i = 0;
		while (cursor.hasNext()) {
			DBObject aCursor = cursor.next();
			int j = 0;
			for (String aField : fields) {
				String[] aFieldArry = aField.split("\\.");
				if (aFieldArry.length == 1) {
					clientFieldValues[i][j] = (String) aCursor.get(aField);
				}
				if (aFieldArry.length == 2) {
					BasicDBObject aobj = (BasicDBObject) aCursor
							.get(aFieldArry[0]);
					clientFieldValues[i][j] = (String) aobj.get(aFieldArry[1]);
				}
				j++;
			}
			i++;
		}

		return clientFieldValues;
	}

	public String[] selectAllRecordByRecordNumber(DBCollection collection,
			String fieldName1, String fieldValue1, String fieldName2,
			String fieldValue2, String[] fields) {
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put(fieldName1, fieldValue1);
		if (fieldName2 != null && fieldValue2 != null) {
			whereQuery.put(fieldName2, fieldValue2);
		}
		String[] fieldValues = new String[fields.length];
		DBCursor cursor = collection.find(whereQuery);
		int i = 0;
		while (cursor.hasNext()) {
			DBObject aCursor = cursor.next();
			for (String aField : fields) {
				fieldValues[i] = (String) aCursor.get(aField);
				i++;
			}

		}
		return fieldValues;
	}

	public ArrayList<String> selectAsListAllRecordByRecordNumber(
			DBCollection collection, String fieldName1, String fieldValue1,
			String field) {
		ArrayList<String> aList = new ArrayList<String>();
		Object aobj = null;
		BasicDBObject whereQuery = new BasicDBObject();

		whereQuery.put(fieldName1, fieldValue1);
		DBCursor cursor = collection.find(whereQuery);
		while (cursor.hasNext()) {
			DBObject aCursor = cursor.next();

			String[] aFieldArry = field.split("\\.");

			if (aFieldArry.length == 1) {
				aobj = aCursor.get(field);
			}
			if (aFieldArry.length == 2) {
				BasicDBObject obj = (BasicDBObject) aCursor.get(aFieldArry[0]);
				aobj = obj.get(aFieldArry[1]);
			}

		}

		if (aobj != null) {
			String[] strArray = aobj.toString().replace("[", "")
					.replace("\\", "").replace("]", "")
					.replaceAll("\"", "\\\\\"").replace("\\\"", "").split(",");

			for (String arr : strArray) {
				aList.add(arr.trim());
			}
		}
		return aList;
	}

	public void updateAllRecordByRecordNumber(DBCollection collection,
			String recordId1, String recordvalue1, String recordId2,
			String recordvalue2, String[] fieldNames, String[] fieldValues) {

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put(recordId1, recordvalue1);
		if (recordId2 != null && recordvalue2 != null) {
			whereQuery.put(recordId2, recordvalue2);
		}

		int i = 0;
		BasicDBObject dbObject = new BasicDBObject();
		for (String field : fieldNames) {
			dbObject.put(field, fieldValues[i]);
			i++;
		}

		collection.update(whereQuery, dbObject);

	}

	public void deleteAllRecordByRecordNumber(DBCollection collection,
			String fieldName1, String fieldValue1, String fieldName2,
			String fieldValue2) {

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put(fieldName1, fieldValue1);

		if (fieldName2 != null && fieldValue2 != null) {
			whereQuery.put(fieldName2, fieldValue2);
		}

		collection.remove(whereQuery);
	}

}