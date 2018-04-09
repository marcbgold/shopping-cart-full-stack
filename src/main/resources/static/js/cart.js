const xhr1 = new XMLHttpRequest()
xhr1.onreadystatechange = function() {
	if (xhr1.readyState === 4 && xhr1.status === 200) {
//		console.warn(xhr1.responseText)
		const res = JSON.parse(xhr1.response)
		console.warn(res)

		if(res.length) {
			res.forEach(function(product) {
				appendOneElementToCart(product)
				appendOneElementToTags(product)
			})
		} else {
			appendOneElementToCart(res)
		}

		function appendOneElementToCart(res) {
			const body = document.querySelector('.cart')

			const cartItemContainer = document.createElement('div')
			cartItemContainer.classList.add('cartItemContainer')

			appendElement(cartItemContainer, createElement('h2', res.name))
			appendElement(cartItemContainer, createElement('p', res.quantity))

			appendElement(body, cartItemContainer)

		}

		function appendOneElementToTags(res){
			const tags = document.querySelector('.tags')

			const tagContainer = document.createElement('div')
			tagContainer.classList.add('tagContainer')

			appendElement(tagContainer, createElement('h2', res.tags.name))

			appendElement(tags, tagContainer)
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

	}
}

xhr1.open('GET', 'http://localhost:8080/cart/1', true)
xhr1.send()