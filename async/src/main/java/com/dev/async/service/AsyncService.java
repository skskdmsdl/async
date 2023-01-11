package com.dev.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

// Async 프로그래밍을 할 때는 반드시 빈 주입을 받아야 함
@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;

    // 빈을 주입받아서 주입받은 빈 안의 메서드를 호출하는 케이스
    public void asyncCall_1() {
        System.out.println("[asyncCall_1] :: " + Thread.currentThread().getName());
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }
    /*  기본적으로 스프링 프레임워크에서 비동기 처리를 하기 위해서는 스프링 프레임워크의 도움이 필요함
        =>비동기로 처리하고자 하는 메서드(빈으로 등록된)를 프록시 객체로 맵핑을 해줘서 프록시 객체를 리턴해줌
        맵핑된 emailService를 받게되고 맵핑된 .sendMail()해주면 비동기로 동작할 수 있게 Sub Thread 에게 위임
        중요한 것은 스프링 컨테이너에 등록된 빈을 사용해야함!
    */

    // 빈 주입이 아니라 인스턴스 선언하고, 인스턴스 메서드 호출 시 비동기로 동작하는지 확인 => 비동기적으로 처리되지 않음
    public void asyncCall_2() {
        System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());
        EmailService emailService = new EmailService();
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }
    /*  인스턴스를 선언해서 사용했기에 스프링 프레임워크에 도움을 못받음(별로 없는 케이스) */

    // 해당 클래스 내의 내부 메서드의 Async 어노테이션 붙이고 그 메서드 호출 시 비동기로 동작하는지 확인 => 비동기적으로 처리되지 않음
    public void asyncCall_3() {
        System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());
    }
    /*  (자주 실수하는 케이스)
        AsyncService는 빈을 가져옴 -> 그 빈 안의 메서드를 다이렉트로 접근하면 이 과정에서는 스프링 프레임워크의 도움을 받을 수 없음
        스프링 프레임워크의 도움은? 해당 빈을 프록시 객체로 한번 맵핑해서 그 맵핑된 빈을 사용할 수 있도록 메서드를 호출해줌
        아래의 @Async가 없는 것과 똑같이 동작함
    */

    @Async
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }
}
