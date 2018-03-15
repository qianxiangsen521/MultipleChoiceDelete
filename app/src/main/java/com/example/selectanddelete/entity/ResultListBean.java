package com.example.selectanddelete.entity;
/**
 * @author qianxiangsen
 */
public class ResultListBean {
        /**
         * title : 美向亚太派第二个航母战斗群
         * vtype : 0
         * duration : 72
         * make_user_id : 许真
         * cp : 央广视讯
         * seq_id : 20140825000982
         * check_status : 0
         * check_user_id :
         * check_memo : null
         */

        private String title;
        private String vtype;
        private String duration;
        private String make_user_id;
        private String cp;
        private long seq_id;
        private String check_status;
        private String check_user_id;
        private String check_memo;
        private String media_id;
        private String down_status;

    public String getDown_status() {
        return down_status;
    }

    public void setDown_status(String down_status) {
        this.down_status = down_status;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVtype() {
            return vtype;
        }

        public void setVtype(String vtype) {
            this.vtype = vtype;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getMake_user_id() {
            return make_user_id;
        }

        public void setMake_user_id(String make_user_id) {
            this.make_user_id = make_user_id;
        }

        public String getCp() {
            return cp;
        }

        public void setCp(String cp) {
            this.cp = cp;
        }

        public long getSeq_id() {
            return seq_id;
        }

        public void setSeq_id(long seq_id) {
            this.seq_id = seq_id;
        }

        public String getCheck_status() {
            return check_status;
        }

        public void setCheck_status(String check_status) {
            this.check_status = check_status;
        }

        public String getCheck_user_id() {
            return check_user_id;
        }

        public void setCheck_user_id(String check_user_id) {
            this.check_user_id = check_user_id;
        }

        public String getCheck_memo() {
            return check_memo;
        }

        public void setCheck_memo(String check_memo) {
            this.check_memo = check_memo;
        }

    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    }