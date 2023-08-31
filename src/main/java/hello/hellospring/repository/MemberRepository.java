package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);// 회원정보 저장
    Optional<Member> findByid(Long id);//회원 시스템 번호
    Optional<Member> findByName(String name);//회원 아이디

    List<Member> findAll();
}
