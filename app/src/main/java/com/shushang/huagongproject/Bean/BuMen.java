package com.shushang.huagongproject.Bean;

import java.util.List;

public class BuMen {


    /**
     * success : true
     * code : 0
     * message : OK
     * data : [{"DepartmentId":11,"DepartmentName":"总部-总经办"},{"DepartmentId":12,"DepartmentName":"总部-销售部"},{"DepartmentId":13,"DepartmentName":"总部-财务部"},{"DepartmentId":14,"DepartmentName":"总部-物流部"},{"DepartmentId":15,"DepartmentName":"总部-研发部"},{"DepartmentId":21,"DepartmentName":"华金分厂"}]
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
         * DepartmentId : 11
         * DepartmentName : 总部-总经办
         */

        private int DepartmentId;
        private String DepartmentName;

        public int getDepartmentId() {
            return DepartmentId;
        }

        public void setDepartmentId(int DepartmentId) {
            this.DepartmentId = DepartmentId;
        }

        public String getDepartmentName() {
            return DepartmentName;
        }

        public void setDepartmentName(String DepartmentName) {
            this.DepartmentName = DepartmentName;
        }
    }
}
