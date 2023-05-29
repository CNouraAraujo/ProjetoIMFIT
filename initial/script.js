// async function getData(){
//     let exercicios = await fetch('http://localhost:8080/api/usuarios');
//     let exerciciosJson = await exercicios.json();
//     console.log(exerciciosJson)
// }

// getData()


// async function getData(){
//     let exercicios = await fetch('exercicios.json');
//     let exerciciosJson = await exercicios.json();
//     console.log(typeof exerciciosJson)
// }

// getData()

// async function addHTML(){
//     let exercicios = (await fetch('exercicios.json')).json();
//     console.log(typeof exercicios)

//     let div = document.getElementById('addElement')
//     let html = ''

// }
// addHTML()


// fetch('http://localhost:8080', {
//     method: 'POST',
//     headers: {
//       'Content-Type': 'application/json'
//     },
//     body: JSON.stringify({
//       username: 'admin',
//       password: 'admin'
//     })
//   })
//   .then(response => {
//     if (response.ok) {
//       return response.json();
//     } else {
//       throw new Error('Erro ao fazer login');
//     }
//   })
//   .then(data => {
//     const token = data.token;
//     console.log('Token de autenticação:', token);
//   })
//   .catch(error => {
//     console.error('Erro ao fazer login:', error);
//   });