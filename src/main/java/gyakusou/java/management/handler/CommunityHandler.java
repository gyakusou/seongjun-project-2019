// 프로젝트 : 취미 커뮤니티 만들기.
//
// v06 handler.CommunityHandler

package gyakusou.java.management.handler;

import java.util.Scanner;
import gyakusou.java.management.domain.Community;

public class CommunityHandler {

  Community[] community = new Community[COMMUNITY_SIZE];
  int communityCount = 0;


  static final int COMMUNITY_SIZE = 100;
  public static Scanner keyboard;


  public static void addCommunity(CommunityHandler communityHandler) {

    Community communitys = new Community();

    System.out.print("번호? ");
    communitys.setNo(keyboard.nextInt());
    keyboard.nextLine();

    System.out.print("아이디? ");
    communitys.setId(keyboard.nextLine());

    System.out.print("닉네임? ");
    communitys.setNickName(keyboard.nextLine());

    System.out.print("제목? ");
    communitys.setTitle(keyboard.nextLine());

    System.out.print("제목+내용? ");
    communitys.setTitleContents(keyboard.nextLine());

    System.out.print("내용? ");
    communitys.setContents(keyboard.nextLine());

    System.out.print("브랜드태그? ");
    communitys.setBrandtag(keyboard.nextLine());

    communityHandler.community[communityHandler.communityCount++] = communitys;

    System.out.println("저장하였습니다.");
  }

  public static void listCommunity(CommunityHandler communityHandler) {

    for (int i = 0; i < communityHandler.communityCount; i++) {

      Community C = communityHandler.community[i];

      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", 
          C.getNo(), C.getId(), C.getNickName(), C.getTitle() , 
          C.getTitleContents(), C.getContents(), C.getBrandtag());

    }

  }
  public static void detailCommunity(CommunityHandler communityHandler) {
    System.out.print("게시물 번호? ");
    int no = keyboard.nextInt();
    keyboard.nextLine(); // 숫자 뒤의 남은 공백 제거

    Community community = null;
    for (int i = 0; i < communityHandler.communityCount; i++) {
      if (communityHandler.community[i].getNo() == no) {
        community = communityHandler.community[i];
        break;
      }
    }

    if (community == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", community.getNo());
    System.out.printf("아이디: %s\n", community.getId());
    System.out.printf("닉네임: %s\n", community.getNickName());
    System.out.printf("제목: %s\n", community.getTitle());
    System.out.printf("제목+내용: %s\n", community.getTitleContents());
    System.out.printf("내용: %s\n", community.getContents());
    System.out.printf("블로그태그: %s\n", community.getBrandtag());
  }

}