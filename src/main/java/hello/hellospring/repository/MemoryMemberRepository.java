package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private  static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;//회원의 키값

    @Override
    public Member save(Member member) {
        member.setId(++sequence);//아이디 세팅
        store.put(member.getId(),member);//저장
        return member;
    }

    @Override
    public Optional<Member> findByid(Long id) {

        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    public void clearStore() {
        store.clear();
    }
}
