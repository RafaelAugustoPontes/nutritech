export default {
    props: ['routes'],

    data() {
        return {
            username : ''
        }
    },

    created(){
        this.username = sessionStorage.getItem('username');
    },

    methods: {
        logout(){
            sessionStorage.clear();
            this.$router.push('/login');
        },
    },
}