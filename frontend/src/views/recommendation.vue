<template>
  <Layout>
    <template>
        <v-app-bar
          dark
        >
        <!-- 타이틀 -->
          <v-toolbar-title><div @click="home">음악 추천</div></v-toolbar-title>
          <v-spacer></v-spacer>
        </v-app-bar>
    </template>

    <template>
      <v-responsive style="aspect-ratio: 16:9">
        <v-main id="inspire">
          <v-container fluid style="padding: 5px">
            <div align="center">
              <v-data-table style="width: auto"
                            :headers="headers"
                            :items="lists"
                            >
               <template #item.title="{ item }">
                  <a :href="item.address" target=_blank>{{ item.title }}</a>
               </template>
              </v-data-table>

              <v-btn outlined @click="home" color="gray"
                           style="padding: auto width: auto">
                다시 하기
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
      { text: '음악 길이', value: 'length' }
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
