import Vue from 'vue'
import App from './App.vue'
import VueToast from 'vue-toast-notification';
import 'vue-toast-notification/dist/theme-default.css';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import { routes } from './routes';
import VueApexCharts from 'vue-apexcharts';

Vue.use(VueToast, {
  position: 'top-right',
  duration: 5000,
  dismissible: true,
});
Vue.use(BootstrapVue);
Vue.use(VueResource);
Vue.use(VueRouter);
Vue.use(VueToast, {
  position: 'top-right',
  duration: 5000,
  dismissible: true,
});

Vue.component('apexchart', VueApexCharts);

let router = new VueRouter({ routes });
Vue.config.productionTip = false;

Vue.prototype.$toastInfo = {
  title: 'Mensagem',
  autoHideDelay: 10000,
  appendToast: false,
  variant: 'info',
};

Vue.prototype.$toastErro = {
  title: 'Erro',
  autoHideDelay: 10000,
  appendToast: false,
  variant: 'danger',
};


Vue.http.interceptors.push((request, next) => {
  if (sessionStorage.getItem('jwt'))
    Vue.http.headers.common['Authorization'] = sessionStorage.getItem('jwt');
  else Vue.http.headers.common['Authorization'] = '';
  next(response => {
    if (response && (response.status === 403 || response.status === 401)) {
      sessionStorage.clear();
      router.push('/login');
    }
  });
});

new Vue({
  render: h => h(App),
  router: router,
}).$mount('#app')
