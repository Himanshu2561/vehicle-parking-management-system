package com.app.dto;

public class DeleteMessageDto {
    String message;
    Integer amount;

    public DeleteMessageDto() {
    }

    public DeleteMessageDto(String message, Integer amount) {
        this.message = message;
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DeleteMessageDto{" +
                "message='" + message + '\'' +
                ", amount=" + amount +
                '}';
    }
}
