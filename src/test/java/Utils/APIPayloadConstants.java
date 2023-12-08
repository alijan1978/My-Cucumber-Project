package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    //we will pass the body in multiple formats, for this we have created this class

    public static String createEmployeePayload(){

        String createEmployeePayload = "{\n" +
                "      \"emp_firstname\": \"Tahseen\",\n" +
                "      \"emp_lastname\": \"Ali\",\n" +
                "      \"emp_middle_name\": \"None\",\n" +
                "      \"emp_gender\": \"M\",\n" +
                "      \"emp_birthday\": \"2023-11-28\",\n" +
                "      \"emp_status\": \"Confirmed\",\n" +
                "      \"emp_job_title\": \"Baby child\"\n" +
                "    }";

        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Tahseen");
        obj.put("emp_lastname","Ali");
        obj.put("emp_middle_name","None");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2023-11-28");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","Baby child");

        return obj.toString();
    }

    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("employee_id", "99067A");
        obj.put("emp_firstname", "Sadeea");
        obj.put("emp_lastname", "Ali");
        obj.put("emp_middle_name", "Sadoo");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "2007-06-03");
        obj.put("emp_status", "Active on duty");
        obj.put("emp_job_title", "Software Engineer");

        return obj.toString();
    }

}
