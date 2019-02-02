package com.shushang.huagongproject.Bean;

import java.util.List;

public class Zhiwu {


    /**
     * success : true
     * code : 0
     * message : OK
     * data : [{"DutyId":111,"DepartmentId":11,"DutyName":"总经理"}]
     */

    private boolean success;
    private int code;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * DutyId : 111
         * DepartmentId : 11
         * DutyName : 总经理
         */

        private int DutyId;
        private int DepartmentId;
        private String DutyName;

        public int getDutyId() {
            return DutyId;
        }

        public void setDutyId(int DutyId) {
            this.DutyId = DutyId;
        }

        public int getDepartmentId() {
            return DepartmentId;
        }

        public void setDepartmentId(int DepartmentId) {
            this.DepartmentId = DepartmentId;
        }

        public String getDutyName() {
            return DutyName;
        }

        public void setDutyName(String DutyName) {
            this.DutyName = DutyName;
        }
    }
}
