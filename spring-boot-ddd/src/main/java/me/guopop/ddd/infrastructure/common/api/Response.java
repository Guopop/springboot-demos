package me.guopop.ddd.infrastructure.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.guopop.ddd.domain.leave.entity.valueobject.Status;

/**
 * @author guopop
 * @date 2021/10/25 11:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

    Status status;
    String msg;
    Object data;

    public static Response ok() {
        return Response.builder().status(Status.SUCCESS).build();
    }

    public static Response ok(Object data) {
        return Response.builder().status(Status.SUCCESS).data(data).build();
    }

    public static Response failed(String msg) {
        return Response.builder().status(Status.FAILED).msg(msg).build();
    }

    public enum Status {
        /**
         * 状态
         */
        SUCCESS,
        FAILED
    }
}