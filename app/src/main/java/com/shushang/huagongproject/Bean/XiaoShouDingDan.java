package com.shushang.huagongproject.Bean;

import java.io.Serializable;
import java.util.List;

public class XiaoShouDingDan {

    /**
     * success : true
     * code : 0
     * message : OK
     * data : [{"Id":"5c529f247eeaf81adc70e5fa","SalesOrderId":"11","BuyerId":"c25b6ba6-50fd-482f-9733-58c43f252374","BuyerTitle":"11","BuyerPurchaseOrderId":null,"Other":null,"Status":0,"CreaterTime":"/Date(1548918564685)/","CreaterId":"43563b9c-d9b7-4ca8-a3f4-152165665104","CreaterName":"测管1","AuditorId":null,"AuditorName":null,"AuditorTime":null,"CancelerId":null,"CancelerName":null,"CancelerTime":null,"PaymentTerm":null,"EstimatedDeliveryTime":"/Date(-62135596800000)/","Items":[{"Id":null,"SalesOrderItemId":"SI19013115092410","SalesOrderId":"11","Series":"CPC","SpecId":"CPC101-000","Spec":{"Id":"5c4e82d0d646a53e1c6b0db7","SpecId":"CPC101-000","Series":"CPC","PeelStrengthMin":2,"PeelStrengthMax":3.5,"PeelStrengthArray":["2.0-2.5","2.5-3.0","3.0-3.5"],"TemperatureResistMax":9999,"TemperatureResistMin":200,"TemperatureResistArray":null,"MolecularWeightMin":0,"MolecularWeightMax":0,"MolecularWeightArray":null,"SolidContentMin":0,"SolidContentMax":0,"SolidContentArray":null,"LowBoilingContentMin":0,"LowBoilingContentMax":0,"LowBoilingContentArray":null},"PeelStrengthStr":"2.0-2.5","PeelStrengthMin":2,"PeelStrengthMax":2.5,"TemperatureResistStr":"","TemperatureResistMax":0,"TemperatureResistMin":0,"MolecularWeightStr":"","MolecularWeightMin":0,"MolecularWeightMax":0,"SolidContentStr":"","SolidContentMin":0,"SolidContentMax":0,"LowBoilingContentStr":"","LowBoilingContentMin":0,"LowBoilingContentMax":0,"Count":10,"UnitPrice":10,"ItemTotalPrice":100,"Note":"哦哦兔子"}]}]
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
         * Id : 5c529f247eeaf81adc70e5fa
         * SalesOrderId : 11
         * BuyerId : c25b6ba6-50fd-482f-9733-58c43f252374
         * BuyerTitle : 11
         * BuyerPurchaseOrderId : null
         * Other : null
         * Status : 0
         * CreaterTime : /Date(1548918564685)/
         * CreaterId : 43563b9c-d9b7-4ca8-a3f4-152165665104
         * CreaterName : 测管1
         * AuditorId : null
         * AuditorName : null
         * AuditorTime : null
         * CancelerId : null
         * CancelerName : null
         * CancelerTime : null
         * PaymentTerm : null
         * EstimatedDeliveryTime : /Date(-62135596800000)/
         * Items : [{"Id":null,"SalesOrderItemId":"SI19013115092410","SalesOrderId":"11","Series":"CPC","SpecId":"CPC101-000","Spec":{"Id":"5c4e82d0d646a53e1c6b0db7","SpecId":"CPC101-000","Series":"CPC","PeelStrengthMin":2,"PeelStrengthMax":3.5,"PeelStrengthArray":["2.0-2.5","2.5-3.0","3.0-3.5"],"TemperatureResistMax":9999,"TemperatureResistMin":200,"TemperatureResistArray":null,"MolecularWeightMin":0,"MolecularWeightMax":0,"MolecularWeightArray":null,"SolidContentMin":0,"SolidContentMax":0,"SolidContentArray":null,"LowBoilingContentMin":0,"LowBoilingContentMax":0,"LowBoilingContentArray":null},"PeelStrengthStr":"2.0-2.5","PeelStrengthMin":2,"PeelStrengthMax":2.5,"TemperatureResistStr":"","TemperatureResistMax":0,"TemperatureResistMin":0,"MolecularWeightStr":"","MolecularWeightMin":0,"MolecularWeightMax":0,"SolidContentStr":"","SolidContentMin":0,"SolidContentMax":0,"LowBoilingContentStr":"","LowBoilingContentMin":0,"LowBoilingContentMax":0,"Count":10,"UnitPrice":10,"ItemTotalPrice":100,"Note":"哦哦兔子"}]
         */

        private String Id;
        private String SalesOrderId;
        private String BuyerId;
        private String BuyerTitle;
        private String BuyerPurchaseOrderId;
        private String Other;
        private int Status;
        private String CreaterTime;
        private String CreaterId;
        private String CreaterName;
        private Object AuditorId;
        private Object AuditorName;
        private Object AuditorTime;
        private Object CancelerId;
        private Object CancelerName;
        private Object CancelerTime;
        private String PaymentTerm;
        private String EstimatedDeliveryTime;
        private List<ItemsBean> Items;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getSalesOrderId() {
            return SalesOrderId;
        }

        public void setSalesOrderId(String SalesOrderId) {
            this.SalesOrderId = SalesOrderId;
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

        public Object getBuyerPurchaseOrderId() {
            return BuyerPurchaseOrderId;
        }

        public void setBuyerPurchaseOrderId(String BuyerPurchaseOrderId) {
            this.BuyerPurchaseOrderId = BuyerPurchaseOrderId;
        }

        public String getOther() {
            return Other;
        }

        public void setOther(String Other) {
            this.Other = Other;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
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

        public Object getCancelerId() {
            return CancelerId;
        }

        public void setCancelerId(Object CancelerId) {
            this.CancelerId = CancelerId;
        }

        public Object getCancelerName() {
            return CancelerName;
        }

        public void setCancelerName(Object CancelerName) {
            this.CancelerName = CancelerName;
        }

        public Object getCancelerTime() {
            return CancelerTime;
        }

        public void setCancelerTime(Object CancelerTime) {
            this.CancelerTime = CancelerTime;
        }

        public String getPaymentTerm() {
            return PaymentTerm;
        }

        public void setPaymentTerm(String PaymentTerm) {
            this.PaymentTerm = PaymentTerm;
        }

        public String getEstimatedDeliveryTime() {
            return EstimatedDeliveryTime;
        }

        public void setEstimatedDeliveryTime(String EstimatedDeliveryTime) {
            this.EstimatedDeliveryTime = EstimatedDeliveryTime;
        }

        public List<ItemsBean> getItems() {
            return Items;
        }

        public void setItems(List<ItemsBean> Items) {
            this.Items = Items;
        }

        public static class ItemsBean implements Serializable{
            /**
             * Id : null
             * SalesOrderItemId : SI19013115092410
             * SalesOrderId : 11
             * Series : CPC
             * SpecId : CPC101-000
             * Spec : {"Id":"5c4e82d0d646a53e1c6b0db7","SpecId":"CPC101-000","Series":"CPC","PeelStrengthMin":2,"PeelStrengthMax":3.5,"PeelStrengthArray":["2.0-2.5","2.5-3.0","3.0-3.5"],"TemperatureResistMax":9999,"TemperatureResistMin":200,"TemperatureResistArray":null,"MolecularWeightMin":0,"MolecularWeightMax":0,"MolecularWeightArray":null,"SolidContentMin":0,"SolidContentMax":0,"SolidContentArray":null,"LowBoilingContentMin":0,"LowBoilingContentMax":0,"LowBoilingContentArray":null}
             * PeelStrengthStr : 2.0-2.5
             * PeelStrengthMin : 2
             * PeelStrengthMax : 2.5
             * TemperatureResistStr :
             * TemperatureResistMax : 0
             * TemperatureResistMin : 0
             * MolecularWeightStr :
             * MolecularWeightMin : 0
             * MolecularWeightMax : 0
             * SolidContentStr :
             * SolidContentMin : 0
             * SolidContentMax : 0
             * LowBoilingContentStr :
             * LowBoilingContentMin : 0
             * LowBoilingContentMax : 0
             * Count : 10
             * UnitPrice : 10
             * ItemTotalPrice : 100
             * Note : 哦哦兔子
             */

            private Object Id;
            private String SalesOrderItemId;
            private String SalesOrderId;
            private String Series;
            private String SpecId;
            private SpecBean Spec;
            private String PeelStrengthStr;
            private double PeelStrengthMin;
            private double PeelStrengthMax;
            private String TemperatureResistStr;
            private double TemperatureResistMax;
            private double TemperatureResistMin;
            private String MolecularWeightStr;
            private double MolecularWeightMin;
            private double MolecularWeightMax;
            private String SolidContentStr;
            private double SolidContentMin;
            private double SolidContentMax;
            private String LowBoilingContentStr;
            private double LowBoilingContentMin;
            private double LowBoilingContentMax;
            private double Count;
            private double UnitPrice;
            private double ItemTotalPrice;
            private String Note;

            public Object getId() {
                return Id;
            }

            public void setId(Object Id) {
                this.Id = Id;
            }

            public String getSalesOrderItemId() {
                return SalesOrderItemId;
            }

            public void setSalesOrderItemId(String SalesOrderItemId) {
                this.SalesOrderItemId = SalesOrderItemId;
            }

            public String getSalesOrderId() {
                return SalesOrderId;
            }

            public void setSalesOrderId(String SalesOrderId) {
                this.SalesOrderId = SalesOrderId;
            }

            public String getSeries() {
                return Series;
            }

            public void setSeries(String Series) {
                this.Series = Series;
            }

            public String getSpecId() {
                return SpecId;
            }

            public void setSpecId(String SpecId) {
                this.SpecId = SpecId;
            }

            public SpecBean getSpec() {
                return Spec;
            }

            public void setSpec(SpecBean Spec) {
                this.Spec = Spec;
            }

            public String getPeelStrengthStr() {
                return PeelStrengthStr;
            }

            public void setPeelStrengthStr(String PeelStrengthStr) {
                this.PeelStrengthStr = PeelStrengthStr;
            }

            public double getPeelStrengthMin() {
                return PeelStrengthMin;
            }

            public void setPeelStrengthMin(int PeelStrengthMin) {
                this.PeelStrengthMin = PeelStrengthMin;
            }

            public double getPeelStrengthMax() {
                return PeelStrengthMax;
            }

            public void setPeelStrengthMax(double PeelStrengthMax) {
                this.PeelStrengthMax = PeelStrengthMax;
            }

            public String getTemperatureResistStr() {
                return TemperatureResistStr;
            }

            public void setTemperatureResistStr(String TemperatureResistStr) {
                this.TemperatureResistStr = TemperatureResistStr;
            }

            public double getTemperatureResistMax() {
                return TemperatureResistMax;
            }

            public void setTemperatureResistMax(int TemperatureResistMax) {
                this.TemperatureResistMax = TemperatureResistMax;
            }

            public double getTemperatureResistMin() {
                return TemperatureResistMin;
            }

            public void setTemperatureResistMin(int TemperatureResistMin) {
                this.TemperatureResistMin = TemperatureResistMin;
            }

            public String getMolecularWeightStr() {
                return MolecularWeightStr;
            }

            public void setMolecularWeightStr(String MolecularWeightStr) {
                this.MolecularWeightStr = MolecularWeightStr;
            }

            public double getMolecularWeightMin() {
                return MolecularWeightMin;
            }

            public void setMolecularWeightMin(int MolecularWeightMin) {
                this.MolecularWeightMin = MolecularWeightMin;
            }

            public double getMolecularWeightMax() {
                return MolecularWeightMax;
            }

            public void setMolecularWeightMax(int MolecularWeightMax) {
                this.MolecularWeightMax = MolecularWeightMax;
            }

            public String getSolidContentStr() {
                return SolidContentStr;
            }

            public void setSolidContentStr(String SolidContentStr) {
                this.SolidContentStr = SolidContentStr;
            }

            public double getSolidContentMin() {
                return SolidContentMin;
            }

            public void setSolidContentMin(int SolidContentMin) {
                this.SolidContentMin = SolidContentMin;
            }

            public double getSolidContentMax() {
                return SolidContentMax;
            }

            public void setSolidContentMax(int SolidContentMax) {
                this.SolidContentMax = SolidContentMax;
            }

            public String getLowBoilingContentStr() {
                return LowBoilingContentStr;
            }

            public void setLowBoilingContentStr(String LowBoilingContentStr) {
                this.LowBoilingContentStr = LowBoilingContentStr;
            }

            public double getLowBoilingContentMin() {
                return LowBoilingContentMin;
            }

            public void setLowBoilingContentMin(int LowBoilingContentMin) {
                this.LowBoilingContentMin = LowBoilingContentMin;
            }

            public double getLowBoilingContentMax() {
                return LowBoilingContentMax;
            }

            public void setLowBoilingContentMax(int LowBoilingContentMax) {
                this.LowBoilingContentMax = LowBoilingContentMax;
            }

            public double getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public double getUnitPrice() {
                return UnitPrice;
            }

            public void setUnitPrice(int UnitPrice) {
                this.UnitPrice = UnitPrice;
            }

            public double getItemTotalPrice() {
                return ItemTotalPrice;
            }

            public void setItemTotalPrice(int ItemTotalPrice) {
                this.ItemTotalPrice = ItemTotalPrice;
            }

            public String getNote() {
                return Note;
            }

            public void setNote(String Note) {
                this.Note = Note;
            }

            public static class SpecBean implements Serializable{
                /**
                 * Id : 5c4e82d0d646a53e1c6b0db7
                 * SpecId : CPC101-000
                 * Series : CPC
                 * PeelStrengthMin : 2
                 * PeelStrengthMax : 3.5
                 * PeelStrengthArray : ["2.0-2.5","2.5-3.0","3.0-3.5"]
                 * TemperatureResistMax : 9999
                 * TemperatureResistMin : 200
                 * TemperatureResistArray : null
                 * MolecularWeightMin : 0
                 * MolecularWeightMax : 0
                 * MolecularWeightArray : null
                 * SolidContentMin : 0
                 * SolidContentMax : 0
                 * SolidContentArray : null
                 * LowBoilingContentMin : 0
                 * LowBoilingContentMax : 0
                 * LowBoilingContentArray : null
                 */

                private String Id;
                private String SpecId;
                private String Series;
                private double PeelStrengthMin;
                private double PeelStrengthMax;
                private double TemperatureResistMax;
                private double TemperatureResistMin;
                private Object TemperatureResistArray;
                private double MolecularWeightMin;
                private double MolecularWeightMax;
                private Object MolecularWeightArray;
                private double SolidContentMin;
                private double SolidContentMax;
                private Object SolidContentArray;
                private double LowBoilingContentMin;
                private double LowBoilingContentMax;
                private Object LowBoilingContentArray;
                private List<String> PeelStrengthArray;

                public String getId() {
                    return Id;
                }

                public void setId(String Id) {
                    this.Id = Id;
                }

                public String getSpecId() {
                    return SpecId;
                }

                public void setSpecId(String SpecId) {
                    this.SpecId = SpecId;
                }

                public String getSeries() {
                    return Series;
                }

                public void setSeries(String Series) {
                    this.Series = Series;
                }

                public double getPeelStrengthMin() {
                    return PeelStrengthMin;
                }

                public void setPeelStrengthMin(int PeelStrengthMin) {
                    this.PeelStrengthMin = PeelStrengthMin;
                }

                public double getPeelStrengthMax() {
                    return PeelStrengthMax;
                }

                public void setPeelStrengthMax(double PeelStrengthMax) {
                    this.PeelStrengthMax = PeelStrengthMax;
                }

                public double getTemperatureResistMax() {
                    return TemperatureResistMax;
                }

                public void setTemperatureResistMax(int TemperatureResistMax) {
                    this.TemperatureResistMax = TemperatureResistMax;
                }

                public double getTemperatureResistMin() {
                    return TemperatureResistMin;
                }

                public void setTemperatureResistMin(int TemperatureResistMin) {
                    this.TemperatureResistMin = TemperatureResistMin;
                }

                public Object getTemperatureResistArray() {
                    return TemperatureResistArray;
                }

                public void setTemperatureResistArray(Object TemperatureResistArray) {
                    this.TemperatureResistArray = TemperatureResistArray;
                }

                public double getMolecularWeightMin() {
                    return MolecularWeightMin;
                }

                public void setMolecularWeightMin(int MolecularWeightMin) {
                    this.MolecularWeightMin = MolecularWeightMin;
                }

                public double getMolecularWeightMax() {
                    return MolecularWeightMax;
                }

                public void setMolecularWeightMax(int MolecularWeightMax) {
                    this.MolecularWeightMax = MolecularWeightMax;
                }

                public Object getMolecularWeightArray() {
                    return MolecularWeightArray;
                }

                public void setMolecularWeightArray(Object MolecularWeightArray) {
                    this.MolecularWeightArray = MolecularWeightArray;
                }

                public double getSolidContentMin() {
                    return SolidContentMin;
                }

                public void setSolidContentMin(int SolidContentMin) {
                    this.SolidContentMin = SolidContentMin;
                }

                public double getSolidContentMax() {
                    return SolidContentMax;
                }

                public void setSolidContentMax(int SolidContentMax) {
                    this.SolidContentMax = SolidContentMax;
                }

                public Object getSolidContentArray() {
                    return SolidContentArray;
                }

                public void setSolidContentArray(Object SolidContentArray) {
                    this.SolidContentArray = SolidContentArray;
                }

                public double getLowBoilingContentMin() {
                    return LowBoilingContentMin;
                }

                public void setLowBoilingContentMin(int LowBoilingContentMin) {
                    this.LowBoilingContentMin = LowBoilingContentMin;
                }

                public double getLowBoilingContentMax() {
                    return LowBoilingContentMax;
                }

                public void setLowBoilingContentMax(int LowBoilingContentMax) {
                    this.LowBoilingContentMax = LowBoilingContentMax;
                }

                public Object getLowBoilingContentArray() {
                    return LowBoilingContentArray;
                }

                public void setLowBoilingContentArray(Object LowBoilingContentArray) {
                    this.LowBoilingContentArray = LowBoilingContentArray;
                }

                public List<String> getPeelStrengthArray() {
                    return PeelStrengthArray;
                }

                public void setPeelStrengthArray(List<String> PeelStrengthArray) {
                    this.PeelStrengthArray = PeelStrengthArray;
                }
            }
        }
    }
}
