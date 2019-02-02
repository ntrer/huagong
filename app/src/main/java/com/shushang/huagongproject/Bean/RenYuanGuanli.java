package com.shushang.huagongproject.Bean;

import java.io.Serializable;
import java.util.List;

public class RenYuanGuanli {


    /**
     * success : true
     * code : 0
     * message : OK
     * data : [{"Id":"5c468626d646a65a80eb7d53","ManagerId":"43563b9c-d9b7-4ca8-a3f4-152165665104","ManagerAccount":"t1","ManagerAccountPassword":"123123","NickName":"测试管理员1","RealName":"测管1","Mobile":null,"DepartmentId":0,"DepartmentName":null,"DutyId":0,"DutyName":null,"Roles":null,"Active":true,"CreateTime":"/Date(1548125734140)/","LastLoginTime":null}]
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

    public static class DataBean implements Serializable {
        /**
         * Id : 5c468626d646a65a80eb7d53
         * ManagerId : 43563b9c-d9b7-4ca8-a3f4-152165665104
         * ManagerAccount : t1
         * ManagerAccountPassword : 123123
         * NickName : 测试管理员1
         * RealName : 测管1
         * Mobile : null
         * DepartmentId : 0
         * DepartmentName : null
         * DutyId : 0
         * DutyName : null
         * Roles : null
         * Active : true
         * CreateTime : /Date(1548125734140)/
         * LastLoginTime : null
         */

        private String Id;
        private String ManagerId;
        private String ManagerAccount;
        private String ManagerAccountPassword;
        private String NickName;
        private String RealName;
        private Object Mobile;
        private int DepartmentId;
        private Object DepartmentName;
        private int DutyId;
        private Object DutyName;
        private Object Roles;
        private boolean Active;
        private String CreateTime;
        private Object LastLoginTime;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getManagerId() {
            return ManagerId;
        }

        public void setManagerId(String ManagerId) {
            this.ManagerId = ManagerId;
        }

        public String getManagerAccount() {
            return ManagerAccount;
        }

        public void setManagerAccount(String ManagerAccount) {
            this.ManagerAccount = ManagerAccount;
        }

        public String getManagerAccountPassword() {
            return ManagerAccountPassword;
        }

        public void setManagerAccountPassword(String ManagerAccountPassword) {
            this.ManagerAccountPassword = ManagerAccountPassword;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getRealName() {
            return RealName;
        }

        public void setRealName(String RealName) {
            this.RealName = RealName;
        }

        public Object getMobile() {
            return Mobile;
        }

        public void setMobile(Object Mobile) {
            this.Mobile = Mobile;
        }

        public int getDepartmentId() {
            return DepartmentId;
        }

        public void setDepartmentId(int DepartmentId) {
            this.DepartmentId = DepartmentId;
        }

        public Object getDepartmentName() {
            return DepartmentName;
        }

        public void setDepartmentName(Object DepartmentName) {
            this.DepartmentName = DepartmentName;
        }

        public int getDutyId() {
            return DutyId;
        }

        public void setDutyId(int DutyId) {
            this.DutyId = DutyId;
        }

        public Object getDutyName() {
            return DutyName;
        }

        public void setDutyName(Object DutyName) {
            this.DutyName = DutyName;
        }

        public Object getRoles() {
            return Roles;
        }

        public void setRoles(Object Roles) {
            this.Roles = Roles;
        }

        public boolean isActive() {
            return Active;
        }

        public void setActive(boolean Active) {
            this.Active = Active;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public Object getLastLoginTime() {
            return LastLoginTime;
        }

        public void setLastLoginTime(Object LastLoginTime) {
            this.LastLoginTime = LastLoginTime;
        }
    }
}
