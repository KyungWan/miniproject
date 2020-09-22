<template>
  <v-app id="inspire">
    <v-app-bar
      app
      clipped-right
      color="blue"
      dark
    >
    <!-- 타이틀 -->
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title><div @click="home">주식 정보 게시판</div></v-toolbar-title>
      <v-spacer></v-spacer>
      <slot name="menubar"></slot>
    </v-app-bar>
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <v-list dense>
      <!-- 리스트 목록  -->
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <v-icon>mdi-exit-to-app</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="home">홈으로 이동</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <v-icon>mdi-exit-to-app</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="category">종목별 분류 보기</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <div> >>> </div>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="recommend">추천 정보 보기</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-container>
      <v-main id="content">
        <slot name="content" class="font">
        </slot>
      </v-main>
    </v-container>

    <v-footer
      app
      color="blue"
      class="white--text"
    >
      <v-spacer></v-spacer>
      <!-- 아래 쪽 글씨 부분 -->
      <span>&copy; 페이지 네이션 연동,개인 회원가입, 검색 기능 연동, (가능하면) 뉴스 링크 연결하기</span>
    </v-footer>
  </v-app>
</template>

<script>
import router from '../router'

export default {
  data: () => ({
    drawer: false,
    left: false
  }),
  methods: {
  // (리스트) 홈으로 이동 등등...
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/Stock') ? router.push('/Stock') : router.go(0)
    },
    // recommend (추천 하는 창 만들기)
    recommend () {
      (window.location.pathname !== '/recommend/list') ? router.push('/recommend/list') : router.go(0)
    }
  }
}
</script>
