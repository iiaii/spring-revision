package me.iiaii.springrevision.practice.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
