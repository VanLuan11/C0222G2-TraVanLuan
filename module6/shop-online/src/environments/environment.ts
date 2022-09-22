// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080',

  firebaseConfig: {
    apiKey: 'AIzaSyBajcaPU0I1DXLr5cUSwhG5gNMSYnoEDiI',
    authDomain: 'tech-store-7cfb5.firebaseapp.com',
    databaseURL: 'https://tech-store-7cfb5-default-rtdb.asia-southeast1.firebasedatabase.app',
    projectId: 'tech-store-7cfb5',
    storageBucket: 'tech-store-7cfb5.appspot.com',
    messagingSenderId: '659833102502',
    appId: '1:659833102502:web:db6e768544382e38c51467',
    measurementId:'"G-L8DT23WELH'
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
