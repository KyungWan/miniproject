<template>
  <Layout>
    <template>
        <v-app-bar
          dark
        >
        <!-- 타이틀 -->
          <v-toolbar-title><div @click="home">음악 분석</div></v-toolbar-title>
          <v-spacer></v-spacer>
        </v-app-bar>
    </template>
    <template>
      <v-responsive style="aspect-ratio: 16:9">
        <v-main id="inspire">
          <v-container fluid style="padding: 5px">
          <!-- Python 연결해서 스펙트럼 들어갈 자리 -->
            <v-img src="@/assets/C_G.jpeg" max-height="270px"> </v-img>
            <div align="center">
              <v-data-table style="width: auto"
                            :headers="headers"
                            :items="lists"
                            >
               <template #item.title="{ item }">
                  <a :href="item.address" target=_blank>{{ item.title }}</a>
               </template>
              </v-data-table>

              <v-btn outlined next to="/recommendation" color="gray"
                           style="padding: auto width: auto">
                비슷한 음악 찾기
              </v-btn>
            </div>
          </v-container>
        </v-main>
      </v-responsive>
    </template>
  </Layout>
</template>

<script>
import router from '../router'

export default {
  name: 'App',
  data: () => ({
    headers: [
      { text: '제목', value: 'title' },
      { text: '장르', value: 'genre' },
      { text: '키워드', value: 'keyword' },
      { text: '사용된 악기', value: 'instrument' }
    ]
  }),
  methods: {
    // (리스트) 홈으로 이동 등등...
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    }
  }
}
</script>

<style scoped>
  div {
    //border: 2px solid black;
    font-family: Ubuntu;
    text-align: center;
    //text-decoration: underline;
    margin: 10px;
    padding: 20px;
  }
</style>
