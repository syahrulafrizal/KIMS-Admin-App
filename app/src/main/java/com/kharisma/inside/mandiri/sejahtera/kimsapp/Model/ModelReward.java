package com.kharisma.inside.mandiri.sejahtera.kimsapp.Model;

public class ModelReward {
    private String rewardName, rewardType;
    private int rewardPoint;

    public ModelReward(String rewardName, String rewardType, int rewardPoint) {
        this.rewardName = rewardName;
        this.rewardType = rewardType;
        this.rewardPoint = rewardPoint;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public int getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(int rewardPoint) {
        this.rewardPoint = rewardPoint;
    }
}
