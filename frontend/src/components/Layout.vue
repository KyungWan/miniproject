<template>
  <v-app id="inspire">
    <v-app-bar
      app
      clipped-right
      color="blue"
      dark
    >
    <!-- 타이틀 -->
      <v-toolbar-title><div @click="home">음악 선정 > 음악 분석 > 음악 추천</div></v-toolbar-title>
      <v-spacer></v-spacer>
      <slot name="menubar"></slot>
    </v-app-bar>

    <v-container>
      <v-main id="content">
        <slot name="content" class="font">
        </slot>
      </v-main>
    </v-container>
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
    }
  }
}
</script>
