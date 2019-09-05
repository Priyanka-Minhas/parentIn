package com.sdei.parentIn.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class MessagesModel extends BaseModel{
    /**
     * statusCode : 200
     * data : [{"attachment":"http://54.71.18.74:4589/uploads/attachments/","message":"messagexdfgsdfgsd","status":false,"_id":"5d70f3d3f1dec57c323b2b36","to":"5d661f79320948394d423511","toName":"T","from":"5d661f79320948394d423511","fromName":"From Name","createdAt":"2019-09-05T11:38:59.477Z"},{"attachment":"http://54.71.18.74:4589/uploads/attachments/","message":"messagexdfgsdfgsd","status":false,"_id":"5d70f3d3f1dec57c323b2b37","to":"5d661f79320948394d423511","toName":"o","from":"5d661f79320948394d423511","fromName":"From Name","createdAt":"2019-09-05T11:38:59.481Z"}]
     * message : Successful
     */

    private ArrayList<DataBean> data;

    public MessagesModel(int toInt, @NotNull String message) {
        super(toInt,message);
    }

    public MessagesModel(@Nullable String message) {
        super(message);
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * attachment : http://54.71.18.74:4589/uploads/attachments/
         * message : messagexdfgsdfgsd
         * status : false
         * _id : 5d70f3d3f1dec57c323b2b36
         * to : 5d661f79320948394d423511
         * toName : T
         * from : 5d661f79320948394d423511
         * fromName : From Name
         * createdAt : 2019-09-05T11:38:59.477Z
         */

        private String attachment;
        private String message;
        private boolean status;
        private String _id;
        private String to;
        private String toName;
        private String from;
        private String fromName;
        private String createdAt;

        public String getAttachment() {
            return attachment;
        }

        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getToName() {
            return toName;
        }

        public void setToName(String toName) {
            this.toName = toName;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getFromName() {
            return fromName;
        }

        public void setFromName(String fromName) {
            this.fromName = fromName;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
    }
}
