
export const routes = [
  {
    path: '/',
    component: () =>
      import('./components/pages/login/login.vue').then(m => m.default),
    hidden: true,
    title : '',
  },
  {
    path: '/login',
    component: () =>
      import('./components/pages/login/login.vue').then(m => m.default),
    hidden: true,
    title : '',
  },
  {
    path: '/home',
    component: () =>
      import('./components/pages/home/home.vue').then(m => m.default),
    hidden: false,
    title : 'Dashboard',
  },
  {
    path: '/weight',
    component: () =>
      import('./components/pages/weight/weight.vue').then(m => m.default),
     hidden: false,
     title : 'Peso'
  },
  {
    path: '/sign-up',
    component: () =>
      import('./components/pages/sign-up/sign-up.vue').then(m => m.default),
     hidden: true,
     title : ''
  },
  {
    path: '/profile',
    component: () =>
      import('./components/pages/profile/profile.vue').then(m => m.default),
     hidden: false,
     title : 'Perfil'
  },
];
