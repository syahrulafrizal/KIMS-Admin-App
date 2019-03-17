package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelReward {
    private String rewardType;
    private int rewardName, rewardPoint;

    public ModelReward(int rewardName, String rewardType, int rewardPoint) {
        this.rewardName = rewardName;
        this.rewardType = rewardType;
        this.rewardPoint = rewardPoint;
    }

    public int getRewardName() {
        return rewardName;
    }

    public void setRewardName(int rewardName) {
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
