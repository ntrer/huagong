package com.shushang.huagongproject.Bean;

import java.io.Serializable;
import java.util.List;

public class CaiGouDingDan {


    /**
     * success : true
     * code : 0
     * message : OK
     * data : [{"Items":[{"Id":null,"PurchaseOrderItemId":"PI19013009271605","PurchaseOrderId":"P19013009271603","MaterielName":"硅","SpecificationName":"CPC","SupplierName":"小木土","UnitPrice":12,"Count":20,"PaymentTerm":"支付宝"},{"Id":null,"PurchaseOrderItemId":"PI19013009271608","PurchaseOrderId":"P19013009271603","MaterielName":"硅","SpecificationName":"Cpc","SupplierName":"阿迪达斯","UnitPrice":300,"Count":10,"PaymentTerm":"微信"}],"Id":"5c50fd747eeafd1ed8fb1450","PurchaseOrderId":"P19013009271603","Status":0,"Note":"没有","CreaterTime":"/Date(1548811636300)/","CreaterId":"43563b9c-d9b7-4ca8-a3f4-152165665104","CreaterName":"测管1","AuditorId":null,"AuditorName":null,"AuditorTime":null}]
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
         * Items : [{"Id":null,"PurchaseOrderItemId":"PI19013009271605","PurchaseOrderId":"P19013009271603","MaterielName":"硅","SpecificationName":"CPC","SupplierName":"小木土","UnitPrice":12,"Count":20,"PaymentTerm":"支付宝"},{"Id":null,"PurchaseOrderItemId":"PI19013009271608","PurchaseOrderId":"P19013009271603","MaterielName":"硅","SpecificationName":"Cpc","SupplierName":"阿迪达斯","UnitPrice":300,"Count":10,"PaymentTerm":"微信"}]
         * Id : 5c50fd747eeafd1ed8fb1450
         * PurchaseOrderId : P19013009271603
         * Status : 0
         * Note : 没有
         * CreaterTime : /Date(1548811636300)/
         * CreaterId : 43563b9c-d9b7-4ca8-a3f4-152165665104
         * CreaterName : 测管1
         * AuditorId : null
         * AuditorName : null
         * AuditorTime : null
         */

        private String Id;
        private String PurchaseOrderId;
        private int Status;
        private String Note;
        private String CreaterTime;
        private String CreaterId;
        private String CreaterName;
        private Object AuditorId;
        private Object AuditorName;
        private Object AuditorTime;
        private List<ItemsBean> Items;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getPurchaseOrderId() {
            return PurchaseOrderId;
        }

        public void setPurchaseOrderId(String PurchaseOrderId) {
            this.PurchaseOrderId = PurchaseOrderId;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getNote() {
            return Note;
        }

        public void setNote(String Note) {
            this.Note = Note;
        }

        public String getCreaterTime() {
            return CreaterTime;
        }

        public void setCreaterTime(String CreaterTime) {
            this.CreaterTime = CreaterTime;
        }

        public String getCreaterId() {
            return CreaterId;
        }

        public void setCreaterId(String CreaterId) {
            this.CreaterId = CreaterId;
        }

        public String getCreaterName() {
            return CreaterName;
        }

        public void setCreaterName(String CreaterName) {
            this.CreaterName = CreaterName;
        }

        public Object getAuditorId() {
            return AuditorId;
        }

        public void setAuditorId(Object AuditorId) {
            this.AuditorId = AuditorId;
        }

        public Object getAuditorName() {
            return AuditorName;
        }

        public void setAuditorName(Object AuditorName) {
            this.AuditorName = AuditorName;
        }

        public Object getAuditorTime() {
            return AuditorTime;
        }

        public void setAuditorTime(Object AuditorTime) {
            this.AuditorTime = AuditorTime;
        }

        public List<ItemsBean> getItems() {
            return Items;
        }

        public void setItems(List<ItemsBean> Items) {
            this.Items = Items;
        }

        public static class ItemsBean {
            /**
             * Id : null
             * PurchaseOrderItemId : PI19013009271605
             * PurchaseOrderId : P19013009271603
             * MaterielName : 硅
             * SpecificationName : CPC
             * SupplierName : 小木土
             * UnitPrice : 12.0
             * Count : 20
             * PaymentTerm : 支付宝
             */

            private Object Id;
            private String PurchaseOrderItemId;
            private String PurchaseOrderId;
            private String MaterielName;
            private String SpecificationName;
            private String SupplierName;
            private double UnitPrice;
            private int Count;
            private String PaymentTerm;

            public Object getId() {
                return Id;
            }

            public void setId(Object Id) {
                this.Id = Id;
            }

            public String getPurchaseOrderItemId() {
                return PurchaseOrderItemId;
            }

            public void setPurchaseOrderItemId(String PurchaseOrderItemId) {
                this.PurchaseOrderItemId = PurchaseOrderItemId;
            }

            public String getPurchaseOrderId() {
                return PurchaseOrderId;
            }

            public void setPurchaseOrderId(String PurchaseOrderId) {
                this.PurchaseOrderId = PurchaseOrderId;
            }

            public String getMaterielName() {
                return MaterielName;
            }

            public void setMaterielName(String MaterielName) {
                this.MaterielName = MaterielName;
            }

            public String getSpecificationName() {
                return SpecificationName;
            }

            public void setSpecificationName(String SpecificationName) {
                this.SpecificationName = SpecificationName;
            }

            public String getSupplierName() {
                return SupplierName;
            }

            public void setSupplierName(String SupplierName) {
                this.SupplierName = SupplierName;
            }

            public double getUnitPrice() {
                return UnitPrice;
            }

            public void setUnitPrice(double UnitPrice) {
                this.UnitPrice = UnitPrice;
            }

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public String getPaymentTerm() {
                return PaymentTerm;
            }

            public void setPaymentTerm(String PaymentTerm) {
                this.PaymentTerm = PaymentTerm;
            }
        }
    }
}
