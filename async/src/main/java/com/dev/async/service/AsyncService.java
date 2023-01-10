package com.dev.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

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

    // 빈 주입이 아니라 인스턴스 선언하고, 인스턴스 메서드 호출 시 비동기로 동작하는지 확인
    public void asyncCall_2() {
        System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());
        EmailService emailService = new EmailService();
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    // 해당 클래스 내의 내부 메서드의 Async 어노테이션 붙이고 그 메서드 호출 시 비동기로 동작하는지 확인
    public void asyncCall_3() {
        System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());
    }

    @Async
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }
}
