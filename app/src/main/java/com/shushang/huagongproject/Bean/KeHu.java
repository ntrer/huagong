package com.shushang.huagongproject.Bean;

import java.io.Serializable;
import java.util.List;

public class KeHu {


    /**
     * success : true
     * code : 0
     * message : OK
     * data : [{"Id":"5c4ecbd47eeb061ab0a9b6d5","BuyerId":"2eb1330c-f136-48e8-acd9-7af10aec77fa","BuyerTitle":"数尚网络","Address":"河南省安阳市规划展示馆","AddressMobile":"18637280068","AddressRealName":"杨栋","BusinessLicenceImage":"upload/201901/20190128_173005_6f97f864b4d44fd59355625ccb21db59.jpg","Active":true,"Note":null,"CreateTime":"/Date(1548667860999)/"},{"Id":"5c4ecbcb7eeb061ab0a9b6d4","BuyerId":"955e1ba8-a397-4884-b60d-c4902c414a51","BuyerTitle":"测试003","Address":"测试003测试002测试002","AddressMobile":"18911756473","AddressRealName":"申向玉3","BusinessLicenceImage":"/upload/2018/09101/ass3.jsp","Active":false,"Note":null,"CreateTime":"/Date(1548667851199)/"},{"Id":"5c4ec3de7eeb051ab08889e8","BuyerId":"b6dce501-d94f-4e73-9cb1-d42f57757b2f","BuyerTitle":"伊川斯美特卫浴","Address":"河南省安阳市万达中心","AddressMobile":"18637280068","AddressRealName":"杨栋","BusinessLicenceImage":"upload/201901/20190128_165700_26168ba456f5400facaf9f8acc4aab85.jpg","Active":true,"Note":null,"CreateTime":"/Date(1548665822569)/"},{"Id":"5c4e5b7f7eeaf61ab0b2b07e","BuyerId":"6b9d4129-50b4-45a0-9bf0-f151b913a9f7","BuyerTitle":"测试0011","Address":"万达中心1","AddressMobile":"18911677771","AddressRealName":"申向玉1","BusinessLicenceImage":"北京拉斯科没地方会计法开始多了几分卡拉涉及到疯狂拉升的","Active":false,"Note":null,"CreateTime":"/Date(1548639103299)/"}]
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
         * Id : 5c4ecbd47eeb061ab0a9b6d5
         * BuyerId : 2eb1330c-f136-48e8-acd9-7af10aec77fa
         * BuyerTitle : 数尚网络
         * Address : 河南省安阳市规划展示馆
         * AddressMobile : 18637280068
         * AddressRealName : 杨栋
         * BusinessLicenceImage : upload/201901/20190128_173005_6f97f864b4d44fd59355625ccb21db59.jpg
         * Active : true
         * Note : null
         * CreateTime : /Date(1548667860999)/
         */

        private String Id;
        private String BuyerId;
        private String BuyerTitle;
        private String Address;
        private String AddressMobile;
        private String AddressRealName;
        private String BusinessLicenceImage;
        private boolean Active;
        private Object Note;
        private String CreateTime;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getBuyerId() {
            return BuyerId;
        }

        public void setBuyerId(String BuyerId) {
            this.BuyerId = BuyerId;
        }

        public String getBuyerTitle() {
            return BuyerTitle;
        }

        public void setBuyerTitle(String BuyerTitle) {
            this.BuyerTitle = BuyerTitle;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getAddressMobile() {
            return AddressMobile;
        }

        public void setAddressMobile(String AddressMobile) {
            this.AddressMobile = AddressMobile;
        }

        public String getAddressRealName() {
            return AddressRealName;
        }

        public void setAddressRealName(String AddressRealName) {
            this.AddressRealName = AddressRealName;
        }

        public String getBusinessLicenceImage() {
            return BusinessLicenceImage;
        }

        public void setBusinessLicenceImage(String BusinessLicenceImage) {
            this.BusinessLicenceImage = BusinessLicenceImage;
        }

        public boolean isActive() {
            return Active;
        }

        public void setActive(boolean Active) {
            this.Active = Active;
        }

        public Object getNote() {
            return Note;
        }

        public void setNote(Object Note) {
            this.Note = Note;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }
    }
}
