import Loading from 'vue-loading-overlay';
import 'vue-loading-overlay/dist/vue-loading.css';

export default {
  props: ['isLoading'],
  components: {
    Loading,
  },
};
