<script>
    import "../app.pcss";
    import { 
        DarkMode,
        Navbar,
        NavBrand,
        NavLi,
        NavUl,
        NavHamburger,
        Footer,
        FooterIcon,
    } from 'flowbite-svelte';
    import { GithubSolid } from 'flowbite-svelte-icons';
</script>


<Navbar rounded color="form">
  <NavBrand href="/">
    <img src="favicon.png" class="me-3 h-6 sm:h-9" alt="WWTM Logo" />
    <span class="self-center whitespace-nowrap text-xl font-semibold dark:text-white">When and Where to Meet ?</span>
  </NavBrand>
  <NavHamburger />
  <NavUl>
    <NavLi href="/">Home</NavLi>
    <NavLi href="/">About</NavLi>
  </NavUl>
  <DarkMode />
</Navbar>

<div class="flex px-4 mx-auto w-full">
	<main class="lg:ml-72 w-full mx-auto">
		<slot />
	</main>
</div>

<hr class="my-6 border-gray-200 sm:mx-auto dark:border-gray-700 lg:my-8" />

<Footer footerType="socialmedia">
  <div class="flex mt-4 space-x-6 rtl:space-x-reverse sm:justify-center sm:mt-0">
    <FooterIcon href="https://github.com/WWToMeet/wwtm">
      <GithubSolid class="w-6 h-6 text-gray-500 dark:text-gray-500 hover:text-gray-900 dark:hover:text-white" />
    </FooterIcon>
  </div>
</Footer>