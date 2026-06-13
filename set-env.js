const fs = require('fs');

const env = JSON.parse(fs.readFileSync('DEV.postman_environment.json', 'utf8'));

const values = {
  baseUrl: 'https://www.shoppersstack.com/shopping',
  userId: '',
  token: '',
  postId: '',
  itemId: '',
  productId: ''
};

env.values.forEach(v => {
  if (values[v.key] !== undefined) {
    v.value = values[v.key];
  }
});

fs.writeFileSync('DEV.postman_environment.json', JSON.stringify(env, null, 2));
console.log('Environment file updated.');