<template>
  <Layout>
    <template #menubar>
    <!-- 메뉴[툴바] -->
      <v-btn @click="start('domestic')" text color="black" style="padding: 10px; width: 90px;">국내</v-btn>

      <v-btn @click="start('global')" text color="black" style="padding: 10px; width: 90px;">해외</v-btn>

      <v-btn @click="start('news#economy')" text color="black" style="padding: 10px; width: 90px;">뉴스</v-btn>

      <v-btn @click="start('exchange')" text color="black" style="padding: 10px; width: 90px;">환율</v-btn>

    </template>
    <template #content>
    <!-- 게시판 -->
      <v-simple-table>
        <template v-slot:default>
          <thead>
            <tr>
            <!-- 목록 -->
              <th class="text-left">No.</th>
              <th class="text-left">제목</th>
            </tr>
          </thead>
          <!-- 크롤링 한 값을 가져옴 [클릭할 때 작동] -->
          <tbody>
            <tr v-for="list of lists" :key="list.title">
              <td style="color: gray">{{ list.newsNo }}</td>
              <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td>
            </tr>
            <div class="card text-center m-3">
              <div class="card-footer pb-0 pt-3">
                <jw-pagination :items="exampleItems" @changePage="onChangePage"></jw-pagination>
              </div>
            </div>
          </tbody>
      <!-- 검색창 ---------------------------------------->
        <div class="row" style="clear:right;width:500px;margin:auto">
          <div class="col-lg-12">
            <form id="searchForm" action="Stock" method="get">
              <select name="type">
                <option value="">전체보기</option>
                <option value="T">제목</option>
                <option value="C">내용</option>
                <option value="TC">제목과 내용</option>
              </select>
              <input type="text" name="keyword" placeholder="검색" />
              <input type="hidden" name="pageNum" placeholder="pageNum">
              <input type="hidden" name="amount" placeholder="amount">
              <button class="btn btn-primary btn-sm"><p style="border-style: groove">Search</p></button>
            </form>
          </div>
        </div>
      <!-- 검색창 -->
        </template>
      </v-simple-table>
    </template>
  </Layout>
</template>

<!--
<div class="card text-center m-3">
  <div class="card-body">
    <div v-for="item in pageOfItems" :key="item.id">{{item.name}}</div>
  </div>
 <div class="card-footer pb-0 pt-3">
   <jw-pagination :items="exampleItems" @changePage="onChangePage"></jw-pagination>
 </div>
</div>
-->

<script>
import Layout from '../components/Layout'
import { mapState } from 'vuex'

// an example array of items to be paged
const exampleItems = [...Array(150).keys()].map(i => ({ id: (i + 1), name: 'Item ' + (i + 1) }))

export default {
  components: { Layout },
  computed: {
    ...mapState({
      lists: state => state.lists
    })
  },
  methods: {
    clickNews (newsNo) {
      console.log('clickNews: ' + newsNo)
      this.$store.dispatch('crawlFindOne', newsNo)
    },
    start (category) {
      this.$store.dispatch('crawlFind', category)
    },
    onChangePage (pageOfItems) {
      // update page of items
      this.pageOfItems = pageOfItems
    }
  },
  data () {
    return {
      exampleItems,
      pageOfItems: []
    }
  }
}
</script>

<style>
  .border-styles > p{
    margin: 2px 0;
    padding: 1px 3px;
    border-width: 2px;
    border-color: #aaa;
  }
  body {
    font-family: Helvetica Neue, Arial, sans-serif;
    font-size: 14px;
    color: #444;
  }

  table {
    border: 2px solid #42b983;
    border-radius: 3px;
    background-color: #fff;
  }

  th {
    background-color: #42b983;
    color: rgba(255, 255, 255, 0.66);
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -user-select: none;
  }

  td {
    background-color: #f9f9f9;
  }

  th,
  td {
    min-width: 120px;
    padding: 10px 20px;
  }

  #search {
    margin-bottom: 10px;
  }
</style>
