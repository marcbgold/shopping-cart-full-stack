const xhr = new XMLHttpRequest()
xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		// console.log(xhr.responseText)
		const res = JSON.parse(xhr.response)

		if(res.length) {
			res.forEach(function(product) {
				appendOneElementToBody(product)
			})
		} else {
			appendOneElementToBody(res)
		}

		function appendOneElementToBody(res) {
			const body = document.querySelector('.container')

			const productContainer = document.createElement('div')
			productContainer.classList.add('productContainer')

			appendElement(productContainer, createElement('h2', res.name))
			appendElement(productContainer, createElement('p', res.info))
			
			appendElement(body, productContainer)
		}

		function createElement(elem, textValue) {
			const newElem = document.createElement(elem)
			newElem.innerText = textValue

			return newElem
		}

		function appendElement(parent, child) {
			parent.appendChild(child)
		}

		function showAllPropsInObject(object) {
			for (prop in res) {
				console.log(`${prop} ${res[prop]}`)
			}
		}

//		console.log(res)
	}
}

xhr.open('GET', 'http://localhost:8080/products', true)
xhr.send()