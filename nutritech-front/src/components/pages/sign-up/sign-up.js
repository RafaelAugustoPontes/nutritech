export default {
	data() {
		return {
			form: {
				fullname: "",
				email: "",
				birthdate: "",
				password: "",
				passwordConfirmation: "",
				gender: "",
				height: 1.7,
				weight: 80,
				isVegetarian: false,
			},
			genders: ["FEMININO", "MASCULINO"],
			isLoading : false,
		}
	},

	methods: {
		onSubmit(evt) {
			evt.preventDefault();
			this.isLoading = true;
			this.$http.post(process.env.VUE_APP_BASE_URI + "users", this.form).then(
				() => {
					this.resetForm();
					this.$toast.success('Cadastro efetuado com sucesso');
					this.isLoading = false
					this.$router.push("/login")
				},
				(erro) => {
					this.$toast.error(erro)
					this.isLoading = false
				},
			)
		},
		goToLogin() {
			this.$router.push("/login")
		},
		resetForm() {
			this.form = {
				fullname: "",
				email: "",
				birthdate: "",
				password: "",
				passwordConfirmation: "",
				gender: "",
				height: 1.7,
				weight: 80,
				isVegetarian: false,
			}
		},
	},
}
