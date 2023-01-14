# async

## 스레드 풀(Thread Pool)
스레드 제어 문제를 해결할 방법으로 스레드 풀을 사용한다. 스레드 풀은 매번 생성 및 수거 요청이 올 때 스레드를 생성하고 수거하는 것이 아닌, 스레드 사용자가 설정해둔 개수만큼 미리 생성해두는 것이다.

## 스레드(Thread)
어떤 프로그램 내에서 실행되는 흐름의 단위
특히 프로세스 내에서 실행되는 흐름의 단위

## 풀(Pool)
필요할 때마다 개체를 할당하고 파괴하는 대신, 사용 준비된 상태로 초기화된 개체 집합

## 비동기의 Thread
비동기는 Main Thread가 아닌 Sub Thread에서 작업이 진행됨

## Java의 비동기
Java에서는 ThreadPool을 생성하여 Async 작업을 처리

## ThreadPool 생성 옵션
1. corePoolSize
기본적으로 관리할 쓰레드 숫자

2. maximumPoolSize
corePoolSize 를 초과하여 최대로 만들 쓰레드 숫자

3. keepAliveTime
corePoolSize 를 초과하여 생성된 쓰레드가 작업을 대기할 시간
이 시간을 초과하면 corePoolSize 를 초과한 개수의 쓰레드를 정리함

4. unit
keepAliveTime 의 단위

5. workQueue
모든 쓰레드가 작업 중일때 task 를 보관할 큐
