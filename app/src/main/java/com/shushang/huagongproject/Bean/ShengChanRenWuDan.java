package com.shushang.huagongproject.Bean;

import java.io.Serializable;
import java.util.List;

public class ShengChanRenWuDan {

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
         * Id : 5c5128cc7eeb011ed8de54aa
         * JobOrderId : null
         * Status : 0
         * Note : 服了
         * BuyerId : 5f66acb0-6aea-4b13-b168-8b7f0119621d
         * BuyerTitle : 辣鸡
         * CreaterTime : /Date(1548822732471)/
         * CreaterId : 43563b9c-d9b7-4ca8-a3f4-152165665104
         * CreaterName : 测管1
         * AuditorId : null
         * AuditorName : null
         * AuditorTime : null
         * CancelerId : null
         * CancelerName : null
         * CancelerTime : null
         * SpecId : S103-50
         * Series : S103
         * Spec : {"Id":"5c4e85c0355dc427802b56de","SpecId":"S103-50","Series":"S103","PeelStrengthMin":0,"PeelStrengthMax":0,"PeelStrengthArray":null,"TemperatureResistMax":9999,"TemperatureResistMin":250,"TemperatureResistArray":null,"MolecularWeightMin":45,"MolecularWeightMax":55,"MolecularWeightArray":["45-50","50-55"],"SolidContentMin":0,"SolidContentMax":0,"SolidContentArray":null,"LowBoilingContentMin":0,"LowBoilingContentMax":10,"LowBoilingContentArray":["0-3","3-6","6-10"]}
         * PeelStrengthMin : 0
         * PeelStrengthMax : 0
         * MolecularWeightMin : 0
         * MolecularWeightMax : 0
         * SolidContentMin : 0
         * SolidContentMax : 0
         * LowBoilingContentMin : 0
         * LowBoilingContentMax : 0
         * Count : 12
         */

        private String Id;
        private String JobOrderId;
        private int Status;
        private String Note;
        private String BuyerId;
        private String BuyerTitle;
        private String CreaterTime;
        private String CreaterId;
        private String CreaterName;
        private Object AuditorId;
        private Object AuditorName;
        private Object AuditorTime;
        private Object CancelerId;
        private Object CancelerName;
        private Object CancelerTime;
        private String SpecId;
        private String Series;
        private SpecBean Spec;
        private double PeelStrengthMin;
        private double PeelStrengthMax;
        private double MolecularWeightMin;
        private double MolecularWeightMax;
        private double SolidContentMin;
        private double SolidContentMax;
        private double LowBoilingContentMin;
        private double LowBoilingContentMax;
        private double Count;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getJobOrderId() {
            return JobOrderId;
        }

        public void setJobOrderId(String JobOrderId) {
            this.JobOrderId = JobOrderId;
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

        public SpecBean getSpec() {
            return Spec;
        }

        public void setSpec(SpecBean Spec) {
            this.Spec = Spec;
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

        public void setPeelStrengthMax(int PeelStrengthMax) {
            this.PeelStrengthMax = PeelStrengthMax;
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

        public static class SpecBean implements Serializable{
            /**
             * Id : 5c4e85c0355dc427802b56de
             * SpecId : S103-50
             * Series : S103
             * PeelStrengthMin : 0
             * PeelStrengthMax : 0
             * PeelStrengthArray : null
             * TemperatureResistMax : 9999
             * TemperatureResistMin : 250
             * TemperatureResistArray : null
             * MolecularWeightMin : 45
             * MolecularWeightMax : 55
             * MolecularWeightArray : ["45-50","50-55"]
             * SolidContentMin : 0
             * SolidContentMax : 0
             * SolidContentArray : null
             * LowBoilingContentMin : 0
             * LowBoilingContentMax : 10
             * LowBoilingContentArray : ["0-3","3-6","6-10"]
             */

            private String Id;
            private String SpecId;
            private String Series;
            private double PeelStrengthMin;
            private double PeelStrengthMax;
            private Object PeelStrengthArray;
            private double TemperatureResistMax;
            private double TemperatureResistMin;
            private Object TemperatureResistArray;
            private double MolecularWeightMin;
            private double MolecularWeightMax;
            private double SolidContentMin;
            private double SolidContentMax;
            private Object SolidContentArray;
            private double LowBoilingContentMin;
            private double LowBoilingContentMax;
            private List<String> MolecularWeightArray;
            private List<String> LowBoilingContentArray;

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

            public void setPeelStrengthMax(int PeelStrengthMax) {
                this.PeelStrengthMax = PeelStrengthMax;
            }

            public Object getPeelStrengthArray() {
                return PeelStrengthArray;
            }

            public void setPeelStrengthArray(Object PeelStrengthArray) {
                this.PeelStrengthArray = PeelStrengthArray;
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

            public List<String> getMolecularWeightArray() {
                return MolecularWeightArray;
            }

            public void setMolecularWeightArray(List<String> MolecularWeightArray) {
                this.MolecularWeightArray = MolecularWeightArray;
            }

            public List<String> getLowBoilingContentArray() {
                return LowBoilingContentArray;
            }

            public void setLowBoilingContentArray(List<String> LowBoilingContentArray) {
                this.LowBoilingContentArray = LowBoilingContentArray;
            }
        }
    }
}
